package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.repository.research.ResearchPaperRepository;
import com.techncat.quantum.app.repository.research.ResearchPatentRepository;
import com.techncat.quantum.app.repository.research.ResearchProjectRepository;
import com.techncat.quantum.app.repository.research.ResearchRewardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResearchSearchService {
    @Resource
    private ResearchPaperRepository paperRepository;
    @Resource
    private ResearchPatentRepository patentRepository;
    @Resource
    private ResearchProjectRepository projectRepository;
    @Resource
    private ResearchRewardRepository rewardRepository;

    public Page<Paper> searchPaper(String word, PageRequest pageRequest) {
        if (word == null) {
            return paperRepository.findAll(pageRequest);
        }
        String wordLike = "%" + word + "%";
        return paperRepository.findAllByTitleLike(wordLike, pageRequest);
    }

    public Page<Patent> searchPatent(String word, PageRequest pageRequest) {
        if (word == null) {
            return patentRepository.findAll(pageRequest);
        }
        String wordLike = "%" + word + "%";
        return patentRepository.findAllByTitleLike(wordLike, pageRequest);
    }

    public Page<Project> searchProject(String word, PageRequest pageRequest) {
        if (word == null) {
            return projectRepository.findAll(pageRequest);
        }
        String wordLike = "%" + word + "%";
        return projectRepository.findAllByTitleLike(wordLike, pageRequest);
    }

    public Page<Reward> searchReward(String word, PageRequest pageRequest) {
        if (word == null) {
            return rewardRepository.findAll(pageRequest);
        }
        String wordLike = "%" + word + "%";
        return rewardRepository.findAllByTitleLike(wordLike, pageRequest);
    }
}
