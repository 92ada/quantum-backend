package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.repository.research.ResearchPaperRepository;
import com.techncat.quantum.app.repository.research.ResearchPatentRepository;
import com.techncat.quantum.app.repository.research.ResearchProjectRepository;
import com.techncat.quantum.app.repository.research.ResearchRewardRepository;
import com.techncat.quantum.app.service.utils.JsonLoader;
import com.techncat.quantum.app.vos.research.PaperVO;
import com.techncat.quantum.app.vos.research.PatentVO;
import com.techncat.quantum.app.vos.research.ProjectVO;
import com.techncat.quantum.app.vos.research.RewardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ResearchUpdateService {
//    @Autowired
//    private VOUtils voUtils;
    @Autowired
    private ResearchShowService showService;
    @Autowired
    private JsonLoader jsonLoader;
    @Resource
    private ResearchPaperRepository researchPaperRepository;
    @Resource
    private ResearchPatentRepository researchPatentRepository;
    @Resource
    private ResearchProjectRepository researchProjectRepository;
    @Resource
    private ResearchRewardRepository researchRewardRepository;

    public Paper update(Long id, PaperVO data) throws ResearchShowService.PaperNotFoundException {
        Paper paper = showService.fetchPaper(id);
        BeanUtils.copyProperties(data, paper);
        paper.setId(id);
        paper.setUpdateAt(new Date());
        paper.setSustech_people(jsonLoader.loadPeopleList(paper.getAuthorJson()));
        return researchPaperRepository.save(paper);
    }

    public Patent update(Long id, PatentVO data) throws ResearchShowService.PatentNotFoundException {
        Patent record = showService.fetchPatent(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        record.setApplicant(jsonLoader.loadPeopleList(record.getApplicantJson()));
        return researchPatentRepository.save(record);
    }

    public Project update(Long id, ProjectVO data) throws ResearchShowService.ProjectNotFoundException {
        Project record = showService.fetchProject(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        return researchProjectRepository.save(record);
    }

    public Reward update(Long id, RewardVO data) throws ResearchShowService.RewardNotFoundException {
        Reward record = showService.fetchReward(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        return researchRewardRepository.save(record);
    }
}
