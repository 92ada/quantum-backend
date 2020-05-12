package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.repository.research.ResearchPaperRepository;
import com.techncat.quantum.app.repository.research.ResearchPatentRepository;
import com.techncat.quantum.app.repository.research.ResearchProjectRepository;
import com.techncat.quantum.app.repository.research.ResearchRewardRepository;
import com.techncat.quantum.app.service.people.LabRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.techncat.quantum.app.common.auth.AuthUtil.isRoot;

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

    @Autowired
    private LabRunner runner;

    public Page<Paper> searchPaper(Aser aser, String word, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return paperRepository.findAll(pageRequest);
        }
        if (word == null) {
            return paperRepository.findAllByIdIn(visiblePapers(aser), pageRequest);
        }
        String wordLike = "%" + word + "%";
        return paperRepository.findAllByTitleLikeAndIdIn(wordLike, visiblePapers(aser), pageRequest);
    }

    private List<Long> visiblePapers(Aser aser) {
        List<Long> result = new ArrayList<>();
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        List<Paper> papers = paperRepository.findAll();
        for (Paper paper : papers) {
            boolean authorOk = paper.getSustech_people().stream().anyMatch(x -> peopleIds.contains(x.getId()));
            if (authorOk) result.add(paper.getId());
        }
        return result;
    }

    public Page<Patent> searchPatent(Aser aser, String word, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return patentRepository.findAll(pageRequest);
        }
        if (word == null) {
            return patentRepository.findAllByIdIn(visiblePatents(aser), pageRequest);
        }
        String wordLike = "%" + word + "%";
        return patentRepository.findAllByTitleLikeAndIdIn(wordLike, visiblePatents(aser), pageRequest);
    }

    private List<Long> visiblePatents(Aser aser) {
        List<Long> result = new ArrayList<>();
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        List<Patent> patents = patentRepository.findAll();
        for (Patent patent : patents) {
            boolean authorOk = patent.getApplicant().stream().anyMatch(x -> peopleIds.contains(x.getId()));
            if (authorOk) result.add(patent.getId());
        }
        return result;
    }

    public Page<Project> searchProject(Aser aser, String word, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return projectRepository.findAll(pageRequest);
        }
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        if (word == null) {
            return projectRepository.findAllByLeader_IdIn(peopleIds, pageRequest);
        }
        String wordLike = "%" + word + "%";
        return projectRepository.findAllByTitleLikeAndLeader_IdIn(wordLike, peopleIds, pageRequest);
    }

    public Page<Reward> searchReward(Aser aser, String word, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return rewardRepository.findAll(pageRequest);
        }
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        if (word == null) {
            return rewardRepository.findAllByRewarded_IdIn(peopleIds, pageRequest);
        }
        String wordLike = "%" + word + "%";
        return rewardRepository.findAllByTitleLikeAndRewarded_IdIn(wordLike, peopleIds, pageRequest);
    }
}
