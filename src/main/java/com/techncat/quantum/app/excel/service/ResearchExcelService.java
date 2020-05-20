package com.techncat.quantum.app.excel.service;

import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.repository.research.ResearchPaperRepository;
import com.techncat.quantum.app.repository.research.ResearchPatentRepository;
import com.techncat.quantum.app.repository.research.ResearchProjectRepository;
import com.techncat.quantum.app.repository.research.ResearchRewardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ResearchExcelService {
    @Resource
    ResearchPatentRepository patentRepository;
    @Resource
    ResearchPaperRepository paperRepository;
    @Resource
    ResearchProjectRepository projectRepository;
    @Resource
    ResearchRewardRepository rewardRepository;

    @Transactional
    public boolean create_or_update(Patent record, boolean forceUpdate) {
        return exist(record) ? update(record, forceUpdate) : create(record);
    }

    @Transactional
    public boolean create_or_update(Paper record, boolean forceUpdate) {
        return exist(record) ? update(record, forceUpdate) : create(record);
    }

    @Transactional
    public boolean create_or_update(Project record, boolean forceUpdate) {
        return exist(record) ? update(record, forceUpdate) : create(record);
    }

    @Transactional
    public boolean create_or_update(Reward record, boolean forceUpdate) {
        return exist(record) ? update(record, forceUpdate) : create(record);
    }

    private boolean exist(Patent p) {
        return patentRepository.findFirstByTitle(p.getTitle()).isPresent();
    }
    private boolean exist(Paper p) {
        return paperRepository.findFirstByTitle(p.getTitle()).isPresent();
    }
    private boolean exist(Project p) {
        return projectRepository.findFirstByTitle(p.getTitle()).isPresent();
    }
    private boolean exist(Reward p) {
        return rewardRepository.findFirstByTitle(p.getTitle()).isPresent();
    }


    private boolean update(Patent p, boolean forceUpdate) {
        if (!forceUpdate) return true;
        Patent original = patentRepository.findFirstByTitle(p.getTitle()).get();
        Long id = original.getId();

        p.setId(id);
        p.setUpdateAt(new Date());
        patentRepository.save(p);
        return true;
    }

    private boolean update(Paper p, boolean forceUpdate) {
        if (!forceUpdate) return true;
        Paper original = paperRepository.findFirstByTitle(p.getTitle()).get();
        Long id = original.getId();

        p.setId(id);
        p.setUpdateAt(new Date());
        paperRepository.save(p);
        return true;
    }

    private boolean update(Project p, boolean forceUpdate) {
        if (!forceUpdate) return true;
        Project original = projectRepository.findFirstByTitle(p.getTitle()).get();
        Long id = original.getId();

        p.setId(id);
        p.setUpdateAt(new Date());
        projectRepository.save(p);
        return true;
    }

    private boolean update(Reward p, boolean forceUpdate) {
        if (!forceUpdate) return true;
        Reward original = rewardRepository.findFirstByTitle(p.getTitle()).get();
        Long id = original.getId();

        p.setId(id);
        p.setUpdateAt(new Date());
        rewardRepository.save(p);
        return true;
    }

    private boolean create(Patent p) {
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());
        patentRepository.save(p);
        return true;
    }

    private boolean create(Paper p) {
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());
        paperRepository.save(p);
        return true;
    }

    private boolean create(Project p) {
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());
        projectRepository.save(p);
        return true;
    }

    private boolean create(Reward p) {
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());
        rewardRepository.save(p);
        return true;
    }
}
