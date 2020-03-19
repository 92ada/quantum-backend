package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.*;
import com.techncat.quantum.app.vos.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class PeopleShowService {

    @Autowired
    private VOUtils voUtils;
    @Resource
    private People_Repository peopleRepository;
    @Resource
    private PeopleAdminRepository peopleAdminRepository;
    @Resource
    private PeoplePostdoctoralRepository peoplePostdoctoralRepository;
    @Resource
    private PeopleResearcherRepository peopleResearcherRepository;
    @Resource
    private PeopleStudentRepository peopleStudentRepository;
    @Resource
    private PeopleTeacherRepository peopleTeacherRepository;
    @Resource
    private PeopleVisitorRepository peopleVisitorRepository;

    public PeopleVO showBase(Long id) throws PeopleNotFoundException {
        People people = fetchBase(id);
        PeopleVO vo = voUtils.copy(people, PeopleVO.class);
        return vo;
    }

    public Object showExtra(People people, People.Type type) throws PeopleNotFoundException {
        switch (type) {
            case administration:
                return voUtils.copy(people.getPeopleAdmin(), PeopleAdminVO.class);
            case postdoctoral:
                return voUtils.copy(people.getPeoplePostdoctoral(), PeoplePostdoctoralVO.class);
            case researcher:
                return voUtils.copy(people.getPeopleResearcher(), PeopleResearcherVO.class);
            case student:
                return voUtils.copy(people.getPeopleStudent(), PeopleStudentVO.class);
            case teacher:
                return voUtils.copy(people.getPeopleTeacher(), PeopleTeacherVO.class);
            case visitor:
                return voUtils.copy(people.getPeopleVisitor(), PeopleVisitorVO.class);
        }
        return null;
    }

    public People fetchBase(Long id) throws PeopleNotFoundException {
        Optional<People> peopleOptional = peopleRepository.findById(id);
        if (peopleOptional.isPresent()) {
            return peopleOptional.get();
        }
        throw new PeopleNotFoundException(id);
    }

    public People fetchBySid(String sid) {
        People people = peopleRepository.findFirstBySid(sid);
        if (people == null) {
            throw new PeopleNotFoundException(sid);
        }
        return people;
    }

    public static class PeopleNotFoundException extends RuntimeException {
        PeopleNotFoundException(Long id) {
            super("People id=[" + id + "] Not Found");
        }

        PeopleNotFoundException(String sid) {
            super("People sid=[" + sid + "] Not Found");
        }
    }
}
