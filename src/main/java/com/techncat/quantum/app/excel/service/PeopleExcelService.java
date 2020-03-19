package com.techncat.quantum.app.excel.service;

import com.techncat.quantum.app.model.people.*;
import com.techncat.quantum.app.repository.people.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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

    /**
     * public::
     */

    @Transactional
    public boolean create_or_update(People people, boolean forceUpdate) {
        return exist(people) ? update(people, forceUpdate) : create(people);
    }

    /**
     * private::
     */

    private boolean exist(People people) {
        return null != people_repository.findFirstBySid(people.getSid());
    }

    private boolean update(People people, boolean forceUpdate) {
        if (!forceUpdate) return true;
        People original = people_repository.findFirstBySid(people.getSid());
        Long id = original.getId();

        // check type
        if (people.getType() != original.getType()) return false; // 类型不一致不可导入 ：：原类型和现在导入的类型不一致

        // dispatch
        switch (people.getType()) {
            case administration:
                PeopleAdmin peopleAdmin = people.getPeopleAdmin();
                peopleAdmin.setId(original.getPeopleAdmin().getId());
                peopleAdmin.setUpdateAt(new Date());
                adminRepository.save(peopleAdmin);
                break;
            case postdoctoral:
                PeoplePostdoctoral peoplePostdoctoral = people.getPeoplePostdoctoral();
                peoplePostdoctoral.setId(original.getPeoplePostdoctoral().getId());
                peoplePostdoctoral.setUpdateAt(new Date());
                postdoctoralRepository.save(peoplePostdoctoral);
                break;
            case researcher:
                PeopleResearcher peopleResearcher = people.getPeopleResearcher();
                peopleResearcher.setId(original.getPeopleResearcher().getId());
                peopleResearcher.setUpdateAt(new Date());
                researcherRepository.save(peopleResearcher);
                break;
            case student:
                PeopleStudent peopleStudent = people.getPeopleStudent();
                peopleStudent.setId(original.getPeopleStudent().getId());
                peopleStudent.setUpdateAt(new Date());
                studentRepository.save(peopleStudent);
                break;
            case teacher:
                PeopleTeacher peopleTeacher = people.getPeopleTeacher();
                peopleTeacher.setId(original.getPeopleTeacher().getId());
                peopleTeacher.setUpdateAt(new Date());
                teacherRepository.save(peopleTeacher);
                break;
            case visitor:
                PeopleVisitor peopleVisitor = people.getPeopleVisitor();
                peopleVisitor.setId(original.getPeopleVisitor().getId());
                peopleVisitor.setUpdateAt(new Date());
                visitorRepository.save(peopleVisitor);
                break;
        }

        // save base
        people.setId(id);
        people.setUpdateAt(new Date());
        people_repository.save(people);
        return true;
    }

    private boolean create(People people) {
        people.setUpdateAt(new Date());
        people.setCreatedAt(new Date());
        switch (people.getType()) {
            case administration:
                PeopleAdmin peopleAdmin = adminRepository.save(people.getPeopleAdmin());
                people.setPeopleAdmin(peopleAdmin);
                people = people_repository.save(people);
                peopleAdmin.setUpdateAt(new Date());
                peopleAdmin.setCreatedAt(new Date());
                adminRepository.save(peopleAdmin);
                break;
            case postdoctoral:
                PeoplePostdoctoral peoplePostdoctoral = postdoctoralRepository.save(people.getPeoplePostdoctoral());
                people.setPeoplePostdoctoral(peoplePostdoctoral);
                people = people_repository.save(people);
                peoplePostdoctoral.setUpdateAt(new Date());
                peoplePostdoctoral.setCreatedAt(new Date());
                postdoctoralRepository.save(peoplePostdoctoral);
                break;
            case researcher:
                PeopleResearcher peopleResearcher = researcherRepository.save(people.getPeopleResearcher());
                people.setPeopleResearcher(peopleResearcher);
                people = people_repository.save(people);
                peopleResearcher.setUpdateAt(new Date());
                peopleResearcher.setCreatedAt(new Date());
                researcherRepository.save(peopleResearcher);
                break;
            case student:
                PeopleStudent peopleStudent = studentRepository.save(people.getPeopleStudent());
                people.setPeopleStudent(peopleStudent);
                people = people_repository.save(people);
                peopleStudent.setUpdateAt(new Date());
                peopleStudent.setCreatedAt(new Date());
                studentRepository.save(peopleStudent);
                break;
            case teacher:
                PeopleTeacher peopleTeacher = teacherRepository.save(people.getPeopleTeacher());
                people.setPeopleTeacher(peopleTeacher);
                people = people_repository.save(people);
                peopleTeacher.setUpdateAt(new Date());
                peopleTeacher.setCreatedAt(new Date());
                teacherRepository.save(peopleTeacher);
                break;
            case visitor:
                PeopleVisitor peopleVisitor = visitorRepository.save(people.getPeopleVisitor());
                people.setPeopleVisitor(peopleVisitor);
                people = people_repository.save(people);
                peopleVisitor.setUpdateAt(new Date());
                peopleVisitor.setCreatedAt(new Date());
                visitorRepository.save(peopleVisitor);
                break;
        }
        return true;
    }
}
