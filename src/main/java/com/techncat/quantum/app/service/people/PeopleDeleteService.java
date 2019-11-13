package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PeopleDeleteService {

    @Autowired
    private PeopleShowService peopleShowService;
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

    public void delete(Long id) throws PeopleShowService.PeopleNotFoundException {
        People people = peopleShowService.fetchBase(id);
        switch (people.getType()) {
            case administration:
                peopleAdminRepository.delete(people.getPeopleAdmin()); break;
            case postdoctoral:
                peoplePostdoctoralRepository.delete(people.getPeoplePostdoctoral()); break;
            case researcher:
                peopleResearcherRepository.delete(people.getPeopleResearcher()); break;
            case student:
                peopleStudentRepository.delete(people.getPeopleStudent()); break;
            case teacher:
                peopleTeacherRepository.delete(people.getPeopleTeacher()); break;
            case visitor:
                peopleVisitorRepository.delete(people.getPeopleVisitor()); break;
        }
        peopleRepository.delete(people);
    }
}
