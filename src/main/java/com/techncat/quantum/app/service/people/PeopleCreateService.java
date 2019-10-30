package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.repo.RepoUtils;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.*;
import com.techncat.quantum.app.repository.people.*;
import com.techncat.quantum.app.vos.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class PeopleCreateService {

    @Autowired
    private RepoUtils repoUtils;
    @Autowired
    private VOUtils voUtils;
    @Resource
    private PeopleRepository peopleRepository;
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

    // 1. base create
    public Object create(PeopleVO vo) throws VOUtils.BeanCopyException {
        return repoUtils.create(peopleRepository, vo, People.class, model -> {
            People people = (People) model;
            people.setId(null);
            people.setUpdateAt(new Date());
            people.setCreatedAt(new Date());
            return people;
        });
    }

    // 2. admin
    public People create(PeopleVO peopleVO, PeopleAdminVO extraVo) throws VOUtils.BeanCopyException {
        PeopleAdmin admin = repoUtils.create(peopleAdminRepository, extraVo, PeopleAdmin.class, model -> {
            PeopleAdmin data = (PeopleAdmin) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleAdmin(admin);
        return peopleRepository.save(people);
    }

    // 3. postdoctoral
    public People create(PeopleVO peopleVO, PeoplePostdoctoralVO extraVo) throws VOUtils.BeanCopyException {
        PeoplePostdoctoral child = repoUtils.create(peoplePostdoctoralRepository, extraVo, PeoplePostdoctoral.class, model -> {
            PeoplePostdoctoral data = (PeoplePostdoctoral) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeoplePostdoctoral(child);
        return peopleRepository.save(people);
    }

    // 4. researcher
    public People create(PeopleVO peopleVO, PeopleResearcherVO extraVo) throws VOUtils.BeanCopyException {
        PeopleResearcher child = repoUtils.create(peopleResearcherRepository, extraVo, PeopleResearcher.class, model -> {
            PeopleResearcher data = (PeopleResearcher) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleResearcher(child);
        return peopleRepository.save(people);
    }

    // 5. student
    public People create(PeopleVO peopleVO, PeopleStudentVO extraVo) throws VOUtils.BeanCopyException {
        PeopleStudent child = repoUtils.create(peopleStudentRepository, extraVo, PeopleStudent.class, model -> {
            PeopleStudent data = (PeopleStudent) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleStudent(child);
        return peopleRepository.save(people);
    }

    // 6. teacher
    public People create(PeopleVO peopleVO, PeopleTeacherVO extraVo) throws VOUtils.BeanCopyException {
        PeopleTeacher child = repoUtils.create(peopleTeacherRepository, extraVo, PeopleTeacher.class, model -> {
            PeopleTeacher data = (PeopleTeacher) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleTeacher(child);
        return peopleRepository.save(people);
    }

    // 7. visitor
    public People create(PeopleVO peopleVO, PeopleVisitorVO extraVo) throws VOUtils.BeanCopyException {
        PeopleVisitor child = repoUtils.create(peopleVisitorRepository, extraVo, PeopleVisitor.class, model -> {
            PeopleVisitor data = (PeopleVisitor) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleVisitor(child);
        return peopleRepository.save(people);
    }

}
