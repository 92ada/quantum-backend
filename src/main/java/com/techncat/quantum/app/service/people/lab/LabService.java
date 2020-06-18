package com.techncat.quantum.app.service.people.lab;

import com.techncat.quantum.app.common.auth.AuthUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.LabRepository;
import com.techncat.quantum.app.service.people.PeopleLabService;
import com.techncat.quantum.app.service.people.PeopleUpdateService;
import com.techncat.quantum.app.vos.people.LabVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabService {
    @Resource
    private LabRepository repository;
    @Autowired
    private PeopleUpdateService peopleUpdateService;
    @Autowired
    private PeopleLabService peopleLabService;

    @Autowired
    private VOUtils voUtils;
    @Autowired
    private AuthUtil authUtil;

    public List<Lab> list(String word) {
        List<Lab> labs;
        if (word == null) labs = repository.findAll();
        else {
            String wordLike = "%" + word + "%";
            labs = repository.findAllByPi_NameLike(wordLike);
        }
        return labs.stream().map(LabService::avoidRef).collect(Collectors.toList());
    }

    public Page<Lab> page(String word, Pageable pageable) {
        Page<Lab> labs;
        if (word == null) labs = repository.findAll(pageable);
        else {
            String wordLike = "%" + word + "%";
            labs = repository.findAllByPi_NameLike(wordLike, pageable);
        }
        return labs.map(LabService::avoidRef);
    }

    public static Lab avoidRef(Lab lab) {
        People _pi = new People();
        _pi.setId(lab.getPi().getId());
        _pi.setName(lab.getPi().getName());

        Lab labCopy = new Lab();
        labCopy.setId(lab.getId());
        labCopy.setPi(_pi);
        labCopy.setDescription(lab.getDescription());
        return labCopy;
    }

    public Lab fetch(Long id) {
        Lab found = repository.findFirstById(id);
        if (found == null) throw new LabNotFoundException(id);
        // avoid $ref of found.fatherLab
        if (found.getFatherLab() != null) {
            found.setFatherLab(avoidRef(found.getFatherLab()));
        }
        return found;
    }

    public Lab create(LabVO vo) {
        Lab data = voUtils.copy(vo, Lab.class);
        data.setId(null);
        data.setCreatedAt(new Date());
        data.setUpdateAt(new Date());
        Lab newLab = repository.save(data);
        addLabToPeople(newLab.getId(), vo.getPi());
        return newLab;
    }

    public Lab update(Long id, LabVO vo) {
        Lab oldLab = fetch(id);
        removeLabFromPeople(id, oldLab.getPi());
        Lab data = voUtils.copy(vo, Lab.class);
        data.setId(id);
        data.setUpdateAt(new Date());
        addLabToPeople(data.getId(), data.getPi());
        return repository.save(data);
    }

    public void delete(Long id) {
        Lab found = fetch(id);
        removeLabFromPeople(id, found.getPi());
        peopleLabService.deleteByLab(found);
        repository.delete(found);
    }

    private void addLabToPeople(Long labId, People people) {
        List<Lab> hisLabs = people.getLab();
        hisLabs.add(fetch(labId));
        peopleUpdateService.update(people.getId(), people);
    }

    private void removeLabFromPeople(Long labId, People people) {
        List<Lab> oldLabs = people.getLab();
        List<Lab> newLabs = oldLabs.stream().filter(lab -> !lab.getId().equals(labId)).collect(Collectors.toList());
        people.setLab(newLabs);
        peopleUpdateService.update(people.getId(), people);
    }

    public static class LabNotFoundException extends RuntimeException {
        LabNotFoundException(Long id) {
            super("Lab not found, id=[" + id + "]");
        }
    }
}
