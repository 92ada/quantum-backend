package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.repo.RepoUtils;
import com.techncat.quantum.app.common.voutils.VOUtils;
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
public class PeopleUpdateService {

    @Autowired
    private RepoUtils repoUtils;
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
    @Autowired
    private PeopleShowService showService;
    @Autowired
    private PeopleLabService peopleLabService;


    // 1. base update
    public People update(Long peopleId, PeopleVO vo) {
        Assert.notNull(vo, "data can not be null");
        List<LabVO> labVOS = vo.getLab();
        People peopleSaved = repoUtils.process(peopleRepository, vo, People.class, model -> {
            People people = (People) model;
            people.setId(peopleId);
            people.setLab(new ArrayList<>());
            people.setUpdateAt(new Date());
            return people;
        });
        peopleLabService.resetLabs(peopleId, labVOS);
        return peopleSaved;
    }

    // 2. admin
    public People update(Long peopleId, PeopleVO peopleVO, PeopleAdminVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();
        PeopleAdmin record = showService.fetchBase(peopleId).getPeopleAdmin();

        return repoUtils.process(peopleVO, extraVo, PeopleAdmin.class, preData1 -> {
            preData1.setId(record.getId());
            preData1.setUpdateAt(new Date());
            return peopleAdminRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(peopleId);
            preData2.setPeopleAdmin(postData1);
            preData2.setLab(new ArrayList<>());
            People postData2 = peopleRepository.save(preData2);
            peopleLabService.resetLabs(peopleId, labVOS);
            postData1.setPeople(postData2);
            peopleAdminRepository.save(postData1);
            return postData2;
        });
    }

    // 3. postdoctoral
    public People update(Long peopleId, PeopleVO peopleVO, PeoplePostdoctoralVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();
        PeoplePostdoctoral record = showService.fetchBase(peopleId).getPeoplePostdoctoral();

        return repoUtils.process(peopleVO, extraVo, PeoplePostdoctoral.class, preData1 -> {
            preData1.setId(record.getId());
            preData1.setUpdateAt(new Date());
            return peoplePostdoctoralRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(peopleId);
            preData2.setPeoplePostdoctoral(postData1);
            preData2.setLab(new ArrayList<>());
            People postData2 = peopleRepository.save(preData2);
            peopleLabService.resetLabs(peopleId, labVOS);
            postData1.setPeople(postData2);
            peoplePostdoctoralRepository.save(postData1);
            return postData2;
        });
    }

    // 4. researcher
    public People update(Long peopleId, PeopleVO peopleVO, PeopleResearcherVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();
        PeopleResearcher record = showService.fetchBase(peopleId).getPeopleResearcher();

        return repoUtils.process(peopleVO, extraVo, PeopleResearcher.class, preData1 -> {
            preData1.setId(record.getId());
            preData1.setUpdateAt(new Date());
            return peopleResearcherRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(peopleId);
            preData2.setPeopleResearcher(postData1);
            preData2.setLab(new ArrayList<>());
            People postData2 = peopleRepository.save(preData2);
            peopleLabService.resetLabs(peopleId, labVOS);
            postData1.setPeople(postData2);
            peopleResearcherRepository.save(postData1);
            return postData2;
        });
    }

    // 5. student
    public People update(Long peopleId, PeopleVO peopleVO, PeopleStudentVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();
        PeopleStudent record = showService.fetchBase(peopleId).getPeopleStudent();

        return repoUtils.process(peopleVO, extraVo, PeopleStudent.class, preData1 -> {
            preData1.setId(record.getId());
            preData1.setUpdateAt(new Date());
            return peopleStudentRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(peopleId);
            preData2.setPeopleStudent(postData1);
            preData2.setLab(new ArrayList<>());
            People postData2 = peopleRepository.save(preData2);
            peopleLabService.resetLabs(peopleId, labVOS);
            postData1.setPeople(postData2);
            peopleStudentRepository.save(postData1);
            return postData2;
        });
    }

    // 6. teacher
    public People update(Long peopleId, PeopleVO peopleVO, PeopleTeacherVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();
        PeopleTeacher record = showService.fetchBase(peopleId).getPeopleTeacher();

        return repoUtils.process(peopleVO, extraVo, PeopleTeacher.class, preData1 -> {
            preData1.setId(record.getId());
            preData1.setUpdateAt(new Date());
            return peopleTeacherRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(peopleId);
            preData2.setPeopleTeacher(postData1);
            preData2.setLab(new ArrayList<>());
            People postData2 = peopleRepository.save(preData2);
            peopleLabService.resetLabs(peopleId, labVOS);
            postData1.setPeople(postData2);
            peopleTeacherRepository.save(postData1);
            return postData2;
        });
    }

    // 7. visitor
    public People update(Long peopleId, PeopleVO peopleVO, PeopleVisitorVO extraVo) {
        Assert.notNull(peopleVO, "data can not be null");
        Assert.notNull(extraVo, "data can not be null");
        List<LabVO> labVOS = peopleVO.getLab();
        PeopleVisitor record = showService.fetchBase(peopleId).getPeopleVisitor();
        return repoUtils.process(peopleVO, extraVo, PeopleVisitor.class, preData1 -> {
            preData1.setId(record.getId());
            preData1.setUpdateAt(new Date());
            return peopleVisitorRepository.save(preData1);
        }, People.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(peopleId);
            preData2.setPeopleVisitor(postData1);
            preData2.setLab(new ArrayList<>());
            People postData2 = peopleRepository.save(preData2);
            peopleLabService.resetLabs(peopleId, labVOS);
            postData1.setPeople(postData2);
            peopleVisitorRepository.save(postData1);
            return postData2;
        });
    }

}
