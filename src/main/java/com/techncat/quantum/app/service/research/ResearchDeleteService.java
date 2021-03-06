package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.repository.research.ResearchPaperRepository;
import com.techncat.quantum.app.repository.research.ResearchPatentRepository;
import com.techncat.quantum.app.repository.research.ResearchProjectRepository;
import com.techncat.quantum.app.repository.research.ResearchRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResearchDeleteService {
    @Autowired
    private ResearchShowService showService;
    @Resource
    private ResearchPaperRepository researchPaperRepository;
    @Resource
    private ResearchPatentRepository researchPatentRepository;
    @Resource
    private ResearchProjectRepository researchProjectRepository;
    @Resource
    private ResearchRewardRepository researchRewardRepository;

    public void deletePaper(Long id) throws ResearchShowService.PaperNotFoundException {
        Paper record = showService.fetchPaper(id);
        researchPaperRepository.delete(record);
    }

    public void deletePatent(Long id) throws ResearchShowService.PatentNotFoundException {
        Patent record = showService.fetchPatent(id);
        researchPatentRepository.delete(record);
    }

    public void deleteProject(Long id) throws ResearchShowService.ProjectNotFoundException {
        Project record = showService.fetchProject(id);
        researchProjectRepository.delete(record);
    }

    public void deleteReward(Long id) throws ResearchShowService.RewardNotFoundException {
        Reward record = showService.fetchReward(id);
        researchRewardRepository.delete(record);
    }
}
