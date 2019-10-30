package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.repo.RepoUtils;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.*;
import com.techncat.quantum.app.repository.people.*;
import com.techncat.quantum.app.vos.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    public People create(PeopleVO vo) {
        Assert.notNull(vo, "data can not be null");
        return repoUtils.create(peopleRepository, vo, People.class, model -> {
            People people = (People) model;
            people.setId(null);
            people.setType(null);
            people.setUpdateAt(new Date());
            people.setCreatedAt(new Date());
            return people;
        });
    }

    // 2. admin
    public People create(PeopleVO peopleVO, PeopleAdminVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");

        return repoUtils.create(peopleVO, extraVo, PeopleAdmin.class, preData1 -> {
            preData1.setId(null);
            preData1.setUpdateAt(new Date());
            preData1.setCreatedAt(new Date());
            return peopleAdminRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setPeopleAdmin(postData1);
            People postData2 = peopleRepository.save(preData2);
            postData1.setPeople(postData2);
            peopleAdminRepository.save(postData1);
            return postData2;
        });
//        PeopleAdmin admin = repoUtils.create(peopleAdminRepository, extraVo, PeopleAdmin.class, model -> {
//            PeopleAdmin data = (PeopleAdmin) model;
//            data.setId(null);
//            data.setUpdateAt(new Date());
//            data.setCreatedAt(new Date());
//            return data;
//        });
////        废弃，和上述一致
////        PeopleAdmin admin = voUtils.copy(extraVo, PeopleAdmin.class);
////        admin.setId(null);
////        admin.setUpdateAt(new Date());
////        admin.setCreatedAt(new Date());
////        admin = peopleAdminRepository.save(admin);
//        People people = voUtils.copy(peopleVO, People.class);
//        people.setPeopleAdmin(admin);
//        people.setType(People.Type.admin);
//        return peopleRepository.save(people);
    }

    // 3. postdoctoral
    public People create(PeopleVO peopleVO, PeoplePostdoctoralVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        PeoplePostdoctoral child = repoUtils.create(peoplePostdoctoralRepository, extraVo, PeoplePostdoctoral.class, model -> {
            PeoplePostdoctoral data = (PeoplePostdoctoral) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeoplePostdoctoral(child);
        people.setType(People.Type.postdoctoral);
        return peopleRepository.save(people);
    }

    // 4. researcher
    public People create(PeopleVO peopleVO, PeopleResearcherVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        PeopleResearcher child = repoUtils.create(peopleResearcherRepository, extraVo, PeopleResearcher.class, model -> {
            PeopleResearcher data = (PeopleResearcher) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleResearcher(child);
        people.setType(People.Type.researcher);
        return peopleRepository.save(people);
    }

    // 5. student
    public People create(PeopleVO peopleVO, PeopleStudentVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        PeopleStudent child = repoUtils.create(peopleStudentRepository, extraVo, PeopleStudent.class, model -> {
            PeopleStudent data = (PeopleStudent) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleStudent(child);
        people.setType(People.Type.student);
        return peopleRepository.save(people);
    }

    // 6. teacher
    public People create(PeopleVO peopleVO, PeopleTeacherVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        PeopleTeacher child = repoUtils.create(peopleTeacherRepository, extraVo, PeopleTeacher.class, model -> {
            PeopleTeacher data = (PeopleTeacher) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleTeacher(child);
        people.setType(People.Type.teacher);
        return peopleRepository.save(people);
    }

    // 7. visitor
    public People create(PeopleVO peopleVO, PeopleVisitorVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        PeopleVisitor child = repoUtils.create(peopleVisitorRepository, extraVo, PeopleVisitor.class, model -> {
            PeopleVisitor data = (PeopleVisitor) model;
            data.setId(null);
            data.setUpdateAt(new Date());
            data.setCreatedAt(new Date());
            return data;
        });
        People people = voUtils.copy(peopleVO, People.class);
        people.setPeopleVisitor(child);
        people.setType(People.Type.visitor);
        return peopleRepository.save(people);
    }

}
