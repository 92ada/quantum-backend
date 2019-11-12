package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.ProjectFund;
import com.techncat.quantum.app.repository.research.ResearchProjectFundRepository;
import com.techncat.quantum.app.vos.research.ProjectFundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectFundService {
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private ResearchShowService showService;
    @Autowired
    private ResearchProjectFundRepository projectFundRepository;

    public List<ProjectFund> list(Project project) {
        return projectFundRepository.findAllByProject(project);
    }

    public ProjectFundVO fetch(Long id) throws ProjectFundNotFoundException {
        ProjectFund info = fetchDO(id);
        return voUtils.copy(info, ProjectFundVO.class);
    }

    public ProjectFund fetchDO(Long id) throws ProjectFundNotFoundException {
        ProjectFund info = projectFundRepository.findFirstById(id);
        if (info != null)
            return info;
        throw new ProjectFundNotFoundException(id);
    }

    public ProjectFund create(Long projectId, ProjectFund info) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(projectId);
        info.setProject(project);
        info.setUpdateAt(new Date());
        info.setCreatedAt(new Date());
        return projectFundRepository.save(info);
    }

    public ProjectFund update(Long projectId, Long familyId, ProjectFund info) throws ResearchShowService.ProjectNotFoundException, ProjectFundNotFoundException {
        ProjectFund record = this.fetchDO(familyId);
        Project project = showService.fetchProject(projectId);
        info.setId(record.getId());
        info.setProject(project);
        info.setUpdateAt(new Date());
        return projectFundRepository.save(info);
    }

    public void delete(Long projectId) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(projectId);
        projectFundRepository.deleteAllByProject(project);
    }

    public void delete(Long projectId, Long familyId) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(projectId);
        projectFundRepository.deleteAllByProjectAndId(project, familyId);
    }

    public static class ProjectFundNotFoundException extends Exception {
        ProjectFundNotFoundException(Long id) { super("ProjectFund id[" + id + "] is not found"); }
    }
}
