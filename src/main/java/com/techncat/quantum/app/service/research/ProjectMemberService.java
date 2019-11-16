package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.model.research.ProjectMember;
import com.techncat.quantum.app.repository.research.ResearchProjectMemberRepository;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectMemberService {
    @Autowired
    private PeopleShowService peopleShowService;
    @Autowired
    private ResearchShowService researchShowService;
    @Resource
    private ResearchProjectMemberRepository repository;

    ProjectMember add(Long projectId, Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        ProjectMember member = new ProjectMember();
        member.setPeople(peopleShowService.fetchBase(peopleId));
        member.setProject(researchShowService.fetchProject(projectId));
        return repository.save(member);
    }
}
