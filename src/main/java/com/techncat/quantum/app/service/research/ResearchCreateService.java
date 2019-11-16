package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.repository.research.ResearchPaperRepository;
import com.techncat.quantum.app.repository.research.ResearchPatentRepository;
import com.techncat.quantum.app.repository.research.ResearchProjectRepository;
import com.techncat.quantum.app.repository.research.ResearchRewardRepository;
import com.techncat.quantum.app.vos.research.PaperVO;
import com.techncat.quantum.app.vos.research.PatentVO;
import com.techncat.quantum.app.vos.research.ProjectVO;
import com.techncat.quantum.app.vos.research.RewardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ResearchCreateService {
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

    public Paper create(PaperVO data) {
        Paper record = voUtils.copy(data, Paper.class);
        record.setId(null);
        record.setUpdateAt(new Date());
        record.setCreatedAt(new Date());
        return researchPaperRepository.save(record);
    }

    public Patent create(PatentVO data) {
        Patent record = voUtils.copy(data, Patent.class);
        record.setId(null);
        record.setUpdateAt(new Date());
        record.setCreatedAt(new Date());
        return researchPatentRepository.save(record);
    }

    public Project create(ProjectVO data) {
        Project record = voUtils.copy(data, Project.class);
        record.setId(null);
        record.setUpdateAt(new Date());
        record.setCreatedAt(new Date());
        return researchProjectRepository.save(record);
    }

    public Reward create(RewardVO data) {
        Reward record = voUtils.copy(data, Reward.class);
        record.setId(null);
        record.setUpdateAt(new Date());
        record.setCreatedAt(new Date());
        return researchRewardRepository.save(record);
    }
}
