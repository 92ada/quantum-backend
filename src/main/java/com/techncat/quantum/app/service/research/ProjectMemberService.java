package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.model.research.ProjectMember;
import com.techncat.quantum.app.repository.research.ResearchProjectMemberRepository;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectMemberService {
    @Autowired
    private PeopleShowService peopleShowService;
    @Autowired
    private ResearchShowService researchShowService;
    @Resource
    private ResearchProjectMemberRepository repository;

    public List<ProjectMember> list(Long projectId) throws ResearchShowService.ProjectNotFoundException {
        return repository.findAllByProject(researchShowService.fetchProject(projectId));
    }

    public ProjectMember add(Long projectId, Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        ProjectMember member = new ProjectMember();
        member.setPeople(peopleShowService.fetchBase(peopleId));
        member.setProject(researchShowService.fetchProject(projectId));
        return repository.save(member);
    }

    public void remove(Long projectId, Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        repository.deleteAllByPeopleAndProject(peopleShowService.fetchBase(peopleId), researchShowService.fetchProject(projectId));
    }
}
