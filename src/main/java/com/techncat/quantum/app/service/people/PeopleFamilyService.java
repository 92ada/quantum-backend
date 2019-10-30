package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.FamilyInfo;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.PeopleFamilyInfoRepository;
import com.techncat.quantum.app.vos.people.FamilyInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PeopleFamilyService {
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private PeopleShowService showService;

    @Autowired
    private PeopleFamilyInfoRepository familyInfoRepository;

    public List<FamilyInfo> list(People people) {
        return familyInfoRepository.findAllByPeople(people);
    }

    public FamilyInfoVO fetch(Long id) throws FamilyInfoNotFoundException {
        FamilyInfo info = fetchDO(id);
        return voUtils.copy(info, FamilyInfoVO.class);
    }

    public FamilyInfo fetchDO(Long id) throws FamilyInfoNotFoundException {
        FamilyInfo info = familyInfoRepository.findFirstById(id);
        if (info != null)
            return info;
        throw new FamilyInfoNotFoundException(id);
    }

    public FamilyInfo create(Long peopleId, FamilyInfo info) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(peopleId);
        info.setPeople(people);
        info.setUpdateAt(new Date());
        info.setCreatedAt(new Date());
        return familyInfoRepository.save(info);
    }

    public FamilyInfo update(Long peopleId, Long familyId, FamilyInfo info) throws PeopleShowService.PeopleNotFoundException, FamilyInfoNotFoundException {
        FamilyInfo record = this.fetchDO(familyId);
        People people = showService.fetchBase(peopleId);
        info.setId(record.getId());
        info.setPeople(people);
        info.setUpdateAt(new Date());
        return familyInfoRepository.save(info);
    }

    public void delete(Long peopleId) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(peopleId);
        familyInfoRepository.deleteAllByPeople(people);
    }

    public void delete(Long peopleId, Long familyId) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(peopleId);
        familyInfoRepository.deleteAllByPeopleAndId(people, familyId);
    }

    public static class FamilyInfoNotFoundException extends Exception {
        FamilyInfoNotFoundException(Long id) {
            super("FamilyInfo id[" + id + "] can not found");
        }
    }
}
