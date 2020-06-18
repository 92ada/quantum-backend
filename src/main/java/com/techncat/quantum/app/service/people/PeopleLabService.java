package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleLab;
import com.techncat.quantum.app.repository.people.PeopleLabRepository;
import com.techncat.quantum.app.vos.people.LabVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleLabService {
    @Resource
    private PeopleLabRepository repository;

    @Transactional
    public void resetLabs(Long peopleId, List<LabVO> labVOS) {
        repository.deleteAllByPeopleId(peopleId);
        if (labVOS == null || labVOS.isEmpty()) return;
        this.update(peopleId, labVOS.parallelStream().map(LabVO::getId).collect(Collectors.toList()));
    }

    public void update(Long peopleId, Long labId) {
        PeopleLab pl = repository.findFirstByPeopleIdAndLabId(peopleId, labId);
        if (pl == null) {
            pl = new PeopleLab();
            pl.setPeopleId(peopleId);
            pl.setLabId(labId);
            repository.save(pl);
        }
    }

    public void update(Long peopleId, List<Long> labIds) {
        if (labIds == null) return;
        labIds.parallelStream().forEach(labId -> this.update(peopleId, labId));
    }

    public void deleteByPeople(People people) {
        repository.deleteAllByPeopleId(people.getId());
    }

    public void deleteByLab(Lab lab) {
        repository.deleteAllByLabId(lab.getId());
    }
}
