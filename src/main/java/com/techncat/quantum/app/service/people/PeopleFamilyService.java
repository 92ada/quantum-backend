package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.FamilyInfo;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.PeopleFamilyInfoRepository;
import com.techncat.quantum.app.vos.people.FamilyInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleFamilyService {
    @Autowired
    private VOUtils voUtils;

    @Autowired
    private PeopleFamilyInfoRepository familyInfoRepository;

    public List<FamilyInfo> list(People people) {
        return familyInfoRepository.findAllByPeople(people);
    }

    public FamilyInfoVO fetch(Long id) throws FamilyInfoNotFoundException, VOUtils.BeanCopyException {
        FamilyInfo info = fetchDO(id);
        return voUtils.copy(info, FamilyInfoVO.class);
    }

    public FamilyInfo fetchDO(Long id) throws FamilyInfoNotFoundException {
        FamilyInfo info = familyInfoRepository.findFirstById(id);
        if (info != null)
            return info;
        throw new FamilyInfoNotFoundException(id);
    }

    public FamilyInfo create(FamilyInfo info) {
        return familyInfoRepository.save(info);
    }

    public static class FamilyInfoNotFoundException extends Exception {
        FamilyInfoNotFoundException(Long id) {
            super("FamilyInfo id[" + id + "] can not found");
        }
    }
}
