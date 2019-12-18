package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.model.research.ProjectAdmin;
import com.techncat.quantum.app.repository.research.ResearchProjectAdminRepository;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectAdminService {
    @Autowired
    private PeopleShowService peopleShowService;
    @Autowired
    private ResearchShowService researchShowService;
    @Resource
    private ResearchProjectAdminRepository repository;

    public List<ProjectAdmin> list(Long projectId) throws ResearchShowService.ProjectNotFoundException {
        return repository.findAllByProject(researchShowService.fetchProject(projectId));
    }

    public ProjectAdmin add(Long projectId, Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        ProjectAdmin admin = new ProjectAdmin();
        admin.setPeople(peopleShowService.fetchBase(peopleId));
        admin.setProject(researchShowService.fetchProject(projectId));
        return repository.save(admin);
    }

    @Transactional
    public void remove(Long projectId, Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        repository.deleteAllByPeopleAndProject(peopleShowService.fetchBase(peopleId), researchShowService.fetchProject(projectId));
    }
}
