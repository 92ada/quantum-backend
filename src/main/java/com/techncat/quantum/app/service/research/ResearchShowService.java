package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.repository.research.*;
import com.techncat.quantum.app.vos.research.PaperVO;
import com.techncat.quantum.app.vos.research.PatentVO;
import com.techncat.quantum.app.vos.research.ProjectVO;
import com.techncat.quantum.app.vos.research.RewardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ResearchShowService {

    @Autowired
    private VOUtils voUtils;
    @Resource
    private ResearchPaperRepository researchPaperRepository;
    @Resource
    private ResearchPatentRepository researchPatentRepository;
    @Resource
    private ResearchProjectRepository researchProjectRepository;
    @Resource
    private ResearchRewardRepository researchRewardRepository;

    public PaperVO showPaper(Long id) throws PaperNotFoundException {
        Optional<Paper> paperOptional = researchPaperRepository.findById(id);
        if (paperOptional.isPresent()) {
            Paper paper = paperOptional.get();
            return voUtils.copy(paper, PaperVO.class);
        }
        throw new PaperNotFoundException(id);
    }

    public PatentVO showPatent(Long id) throws PatentNotFoundException {
        Optional<Patent> patentOptional = researchPatentRepository.findById(id);
        if (patentOptional.isPresent()) {
            Patent patent = patentOptional.get();
            return voUtils.copy(patent, PatentVO.class);
        }
        throw new PatentNotFoundException(id);
    }

    public ProjectVO showProject(Long id) throws ProjectNotFoundException {
        Project project = fetchProject(id);
        return voUtils.copy(project, ProjectVO.class);
    }

    public Project fetchProject(Long id) throws ProjectNotFoundException {
        Optional<Project> projectOptional = researchProjectRepository.findById(id);
        if (projectOptional.isPresent()) {
            return projectOptional.get();
        }
        throw new ProjectNotFoundException(id);
    }

    public RewardVO showReward(Long id) throws RewardNotFoundException {
        Optional<Reward> rewardOptional = researchRewardRepository.findById(id);
        if (rewardOptional.isPresent()) {
            Reward reward = rewardOptional.get();
            return voUtils.copy(reward, RewardVO.class);
        }
        throw new RewardNotFoundException(id);
    }

    public static class PaperNotFoundException extends Exception {
        PaperNotFoundException(Long id) { super("Paper id=[" + id + "] Not Found"); }
    }

    public static class PatentNotFoundException extends Exception {
        PatentNotFoundException(Long id) { super("Patent id=[" + id + "] Not Found"); }
    }

    public static class ProjectNotFoundException extends Exception {
        ProjectNotFoundException(Long id) { super("Project id=[" + id + "] Not Found"); }
    }

    public static class RewardNotFoundException extends Exception {
        RewardNotFoundException(Long id) { super("Reward id=[" + id + "] Not Found"); }
    }
}
