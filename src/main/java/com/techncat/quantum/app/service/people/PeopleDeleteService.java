package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class PeopleDeleteService {

    @Autowired
    private PeopleShowService peopleShowService;
    @Autowired
    private PeopleLabService peopleLabService;
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

    @Transactional
    public void delete(Long id) throws PeopleShowService.PeopleNotFoundException {
        People people = peopleShowService.fetchBase(id);
        peopleLabService.deleteByPeople(people);

        if (people.getType() != null) {
            switch (people.getType()) {
                case administration:
                    if (null != people.getPeopleAdmin())
                        peopleAdminRepository.delete(people.getPeopleAdmin());
                    break;
                case postdoctoral:
                    if (null != people.getPeoplePostdoctoral())
                        peoplePostdoctoralRepository.delete(people.getPeoplePostdoctoral());
                    break;
                case researcher:
                    if (null != people.getPeopleResearcher())
                        peopleResearcherRepository.delete(people.getPeopleResearcher());
                    break;
                case student:
                    if (null != people.getPeopleStudent())
                        peopleStudentRepository.delete(people.getPeopleStudent());
                    break;
                case teacher:
                    if (null != people.getPeopleTeacher())
                        peopleTeacherRepository.delete(people.getPeopleTeacher());
                    break;
                case visitor:
                    if (null != people.getPeopleVisitor())
                        peopleVisitorRepository.delete(people.getPeopleVisitor());
                    break;
            }
        }
        peopleRepository.delete(people);
    }
}
