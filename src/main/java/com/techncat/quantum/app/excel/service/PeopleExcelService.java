package com.techncat.quantum.app.excel.service;

import com.techncat.quantum.app.model.people.*;
import com.techncat.quantum.app.repository.people.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PeopleExcelService {

    @Resource
    private People_Repository people_repository;
    @Resource
    private PeopleAdminRepository adminRepository;
    @Resource
    private PeoplePostdoctoralRepository postdoctoralRepository;
    @Resource
    private PeopleResearcherRepository researcherRepository;
    @Resource
    private PeopleStudentRepository studentRepository;
    @Resource
    private PeopleTeacherRepository teacherRepository;
    @Resource
    private PeopleVisitorRepository visitorRepository;

    public Boolean exist(People people) {
        return null != people_repository.findFirstBySid(people.getSid());
    }

    @Transactional
    public People update(People people) {
        People original = people_repository.findFirstBySid(people.getSid());
        Long id = original.getId();

        switch (people.getType()) {
            case administration:
                PeopleAdmin peopleAdmin = people.getPeopleAdmin();
                peopleAdmin.setId(original.getPeopleAdmin().getId());
                adminRepository.save(peopleAdmin);
                break;
            case postdoctoral:
                PeoplePostdoctoral peoplePostdoctoral = people.getPeoplePostdoctoral();
                peoplePostdoctoral.setId(original.getPeoplePostdoctoral().getId());
                postdoctoralRepository.save(peoplePostdoctoral);
                break;
            case researcher:
                PeopleResearcher peopleResearcher = people.getPeopleResearcher();
                peopleResearcher.setId(original.getPeopleResearcher().getId());
                researcherRepository.save(peopleResearcher);
                break;
            case student:
                PeopleStudent peopleStudent = people.getPeopleStudent();
                peopleStudent.setId(original.getPeopleStudent().getId());
                studentRepository.save(peopleStudent);
                break;
            case teacher:
                PeopleTeacher peopleTeacher = people.getPeopleTeacher();
                peopleTeacher.setId(original.getPeopleTeacher().getId());
                teacherRepository.save(peopleTeacher);
                break;
            case visitor:
                PeopleVisitor peopleVisitor = people.getPeopleVisitor();
                peopleVisitor.setId(original.getPeopleVisitor().getId());
                visitorRepository.save(peopleVisitor);
                break;
        }
        people.setId(id);
        return people_repository.save(people);
    }

    @Transactional
    public People create(People people) {
        switch (people.getType()) {
            case administration:
                PeopleAdmin peopleAdmin = adminRepository.save(people.getPeopleAdmin());
                people.setPeopleAdmin(peopleAdmin);
                people = people_repository.save(people);
                peopleAdmin.setPeople(people);
                adminRepository.save(peopleAdmin);
                break;
            case postdoctoral:
                PeoplePostdoctoral peoplePostdoctoral = postdoctoralRepository.save(people.getPeoplePostdoctoral());
                people.setPeoplePostdoctoral(peoplePostdoctoral);
                people = people_repository.save(people);
                peoplePostdoctoral.setPeople(people);
                postdoctoralRepository.save(peoplePostdoctoral);
                break;
            case researcher:
                PeopleResearcher peopleResearcher = researcherRepository.save(people.getPeopleResearcher());
                people.setPeopleResearcher(peopleResearcher);
                people = people_repository.save(people);
                peopleResearcher.setPeople(people);
                researcherRepository.save(peopleResearcher);
                break;
            case student:
                PeopleStudent peopleStudent = studentRepository.save(people.getPeopleStudent());
                people.setPeopleStudent(peopleStudent);
                people = people_repository.save(people);
                peopleStudent.setPeople(people);
                studentRepository.save(peopleStudent);
                break;
            case teacher:
                PeopleTeacher peopleTeacher = teacherRepository.save(people.getPeopleTeacher());
                people.setPeopleTeacher(peopleTeacher);
                people = people_repository.save(people);
                peopleTeacher.setPeople(people);
                teacherRepository.save(peopleTeacher);
                break;
            case visitor:
                PeopleVisitor peopleVisitor = visitorRepository.save(people.getPeopleVisitor());
                people.setPeopleVisitor(peopleVisitor);
                people = people_repository.save(people);
                peopleVisitor.setPeople(people);
                visitorRepository.save(peopleVisitor);
                break;
        }
        return people;
    }
}
