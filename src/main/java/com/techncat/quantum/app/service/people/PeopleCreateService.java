package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.repo.RepoUtils;
import com.techncat.quantum.app.model.people.*;
import com.techncat.quantum.app.repository.people.*;
import com.techncat.quantum.app.vos.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PeopleCreateService {

    @Autowired
    private RepoUtils repoUtils;
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

    private List<Lab> loadLab(List<LabVO> labVOS) {
        if (labVOS.isEmpty()) return new ArrayList<>();
        List<Lab> labs = new ArrayList<>();
        for (LabVO labVO: labVOS) {
            Lab lab = new Lab();
            lab.setId(labVO.getId());
            labs.add(lab);
        }
        return labs;
    }

    // 1. base create
    public People create(PeopleVO vo) {
        Assert.notNull(vo, "data can not be null");
        List<LabVO> labVOS = vo.getLab();
        return repoUtils.process(peopleRepository, vo, People.class, model -> {
            People people = (People) model;
            people.setId(null);
            people.setLab(loadLab(labVOS));
            people.setType(People.Type.base);
            people.setUpdateAt(new Date());
            people.setCreatedAt(new Date());
            return people;
        });
    }

    // 2. admin
    public People create(PeopleVO peopleVO, PeopleAdminVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();

        return repoUtils.process(peopleVO, extraVo, PeopleAdmin.class, preData1 -> {
            preData1.setId(null);
            preData1.setUpdateAt(new Date());
            preData1.setCreatedAt(new Date());
            return peopleAdminRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(null);
            preData2.setLab(loadLab(labVOS));
            preData2.setPeopleAdmin(postData1);
            preData2.setType(People.Type.administration);
            People postData2 = peopleRepository.save(preData2);
            postData1.setPeople(postData2);
            peopleAdminRepository.save(postData1);
            return postData2;
        });
    }

    // 3. postdoctoral
    public People create(PeopleVO peopleVO, PeoplePostdoctoralVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();

        return repoUtils.process(peopleVO, extraVo, PeoplePostdoctoral.class, preData1 -> {
            preData1.setId(null);
            preData1.setUpdateAt(new Date());
            preData1.setCreatedAt(new Date());
            return peoplePostdoctoralRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(null);
            preData2.setLab(loadLab(labVOS));
            preData2.setPeoplePostdoctoral(postData1);
            preData2.setType(People.Type.postdoctoral);
            People postData2 = peopleRepository.save(preData2);
            postData1.setPeople(postData2);
            peoplePostdoctoralRepository.save(postData1);
            return postData2;
        });
    }

    // 4. researcher
    public People create(PeopleVO peopleVO, PeopleResearcherVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();

        return repoUtils.process(peopleVO, extraVo, PeopleResearcher.class, preData1 -> {
            preData1.setId(null);
            preData1.setUpdateAt(new Date());
            preData1.setCreatedAt(new Date());
            return peopleResearcherRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(null);
            preData2.setLab(loadLab(labVOS));
            preData2.setPeopleResearcher(postData1);
            preData2.setType(People.Type.researcher);
            People postData2 = peopleRepository.save(preData2);
            postData1.setPeople(postData2);
            peopleResearcherRepository.save(postData1);
            return postData2;
        });
    }

    // 5. student
    public People create(PeopleVO peopleVO, PeopleStudentVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();

        return repoUtils.process(peopleVO, extraVo, PeopleStudent.class, preData1 -> {
            preData1.setId(null);
            preData1.setUpdateAt(new Date());
            preData1.setCreatedAt(new Date());
            return peopleStudentRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(null);
            preData2.setLab(loadLab(labVOS));
            preData2.setPeopleStudent(postData1);
            preData2.setType(People.Type.student);
            People postData2 = peopleRepository.save(preData2);
            postData1.setPeople(postData2);
            peopleStudentRepository.save(postData1);
            return postData2;
        });
    }

    // 6. teacher
    public People create(PeopleVO peopleVO, PeopleTeacherVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();

        return repoUtils.process(peopleVO, extraVo, PeopleTeacher.class, preData1 -> {
            preData1.setId(null);
            preData1.setUpdateAt(new Date());
            preData1.setCreatedAt(new Date());
            return peopleTeacherRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(null);
            preData2.setLab(loadLab(labVOS));
            preData2.setPeopleTeacher(postData1);
            preData2.setType(People.Type.teacher);
            People postData2 = peopleRepository.save(preData2);
            postData1.setPeople(postData2);
            peopleTeacherRepository.save(postData1);
            return postData2;
        });
    }

    // 7. visitor
    public People create(PeopleVO peopleVO, PeopleVisitorVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();

        return repoUtils.process(peopleVO, extraVo, PeopleVisitor.class, preData1 -> {
            preData1.setId(null);
            preData1.setUpdateAt(new Date());
            preData1.setCreatedAt(new Date());
            return peopleVisitorRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(null);
            preData2.setLab(loadLab(labVOS));
            preData2.setPeopleVisitor(postData1);
            preData2.setType(People.Type.visitor);
            People postData2 = peopleRepository.save(preData2);
            postData1.setPeople(postData2);
            peopleVisitorRepository.save(postData1);
            return postData2;
        });
    }

}
