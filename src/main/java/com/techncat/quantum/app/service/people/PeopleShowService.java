package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.repository.people.*;
import com.techncat.quantum.app.vos.people.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class PeopleShowService {

    @Resource private PeopleRepository peopleRepository;
    @Resource private PeopleAdminRepository peopleAdminRepository;
    @Resource private PeoplePostdoctoralRepository peoplePostdoctoralRepository;
    @Resource private PeopleResearcherRepository peopleResearcherRepository;
    @Resource private PeopleStudentRepository peopleStudentRepository;
    @Resource private PeopleTeacherRepository peopleTeacherRepository;
    @Resource private PeopleVisitorRepository peopleVisitorRepository;

    public PeopleVO show(Long id) throws PeopleNotFoundException {
        People people = fetchBase(id);
        switch (people.getType()) {
            case admin:
                return new PeopleAdminVO(people, peopleAdminRepository.findByPeople(people));
            case postdoctoral:
                return new PeoplePostdoctoralVO(people, peoplePostdoctoralRepository.findByPeople(people));
            case researcher:
                return new PeopleResearcherVO(people, peopleResearcherRepository.findByPeople(people));
            case student:
                return new PeopleStudentVO(people, peopleStudentRepository.findByPeople(people));
            case teacher:
                return new PeopleTeacherVO(people, peopleTeacherRepository.findByPeople(people));
            case visitor:
                return new PeopleVisitorVO(people, peopleVisitorRepository.findByPeople(people));
        }
        return new PeopleVO(people);
    }

    private People fetchBase(Long id) throws PeopleNotFoundException {
        Optional<People> peopleOptional = peopleRepository.findById(id);
        if (peopleOptional.isPresent()) {
            return peopleOptional.get();
        }
        throw new PeopleNotFoundException(id);
    }

    public static class PeopleNotFoundException extends Exception{
        PeopleNotFoundException(Long id) {
            super("People id=[" + id + "] Not Found");
        }
    }
}
