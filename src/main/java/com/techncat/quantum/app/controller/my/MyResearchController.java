package com.techncat.quantum.app.controller.my;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.*;
import com.techncat.quantum.app.repository.research.ResearchPaperAuthorRepository;
import com.techncat.quantum.app.repository.research.ResearchPatentRepository;
import com.techncat.quantum.app.repository.research.ResearchProjectRepository;
import com.techncat.quantum.app.repository.research.ResearchRewardRepository;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/my/research")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class MyResearchController {
    @Resource
    private ResearchPaperAuthorRepository paperAuthorRepository;
    @Resource
    private ResearchPatentRepository patentRepository;
    @Resource
    private ResearchProjectRepository projectRepository;
    @Resource
    private ResearchRewardRepository rewardRepository;
    @Autowired
    private PeopleShowService showService;


    @GetMapping("/project")
    public List<Project> searchProject(@ForkiAser Aser aser) {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        return projectRepository.findAllByLeader(people);
    }

    @GetMapping("/paper")
    public List<Paper> searchPaper(@ForkiAser Aser aser) {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        return paperAuthorRepository.findAllByPeople(people).parallelStream().map(PaperAuthor::getPaper).collect(Collectors.toList());
    }

    @GetMapping("/reward")
    public List<Reward> searchRewarded(@ForkiAser Aser aser) {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        return rewardRepository.findAllByRewarded(people);
    }

    @GetMapping("/patent")
    public List<Patent> searchPatent(@ForkiAser Aser aser) {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        return patentRepository.findAllByApplicantContains(people);
    }
}
