package com.techncat.quantum.app.service.research;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.ProjectMember;
import com.techncat.quantum.app.repository.research.ResearchProjectMemberRepository;
import com.techncat.quantum.app.vos.research.ProjectMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ProjectMemberService {
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private ResearchShowService showService;
    @Autowired
    private ResearchProjectMemberRepository projectMemberRepository;
    @Autowired
    private ResearchShowService researchShowService;

    public List<ProjectMember> list(Long projectId) throws ResearchShowService.ProjectNotFoundException {
        return list(researchShowService.fetchProject(projectId));
    }

    public List<ProjectMember> list(Project project) {
        return projectMemberRepository.findAllByProject(project);
    }

    public ProjectMemberVO fetch(Long id) throws ProjectMemberNotFoundException {
        ProjectMember info = fetchDO(id);
        return voUtils.copy(info, ProjectMemberVO.class);
    }

    public ProjectMember fetchDO(Long memberId) throws ProjectMemberNotFoundException {
        ProjectMember info = projectMemberRepository.findFirstById(memberId);
        if (info != null)
            return info;
        throw new ProjectMemberNotFoundException(memberId);
    }

    public ProjectMember create(Long projectId, ProjectMember info) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(projectId);
        info.setProject(project);
        info.setUpdateAt(new Date());
        info.setCreatedAt(new Date());
        return projectMemberRepository.save(info);
    }

    public ProjectMember update(Long projectId, Long memberId, ProjectMember info) throws ResearchShowService.ProjectNotFoundException, ProjectMemberNotFoundException {
        ProjectMember record = this.fetchDO(memberId);
        Project project = showService.fetchProject(projectId);
        info.setId(record.getId());
        info.setProject(project);
        info.setUpdateAt(new Date());
        return projectMemberRepository.save(info);
    }

    @Transactional
    public void delete(Long projectId) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(projectId);
        projectMemberRepository.deleteAllByProject(project);
    }

    @Transactional
    public void delete(Long projectId, Long memberId) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(projectId);
        projectMemberRepository.deleteAllByProjectAndId(project, memberId);
    }

    public static class ProjectMemberNotFoundException extends Exception {
        ProjectMemberNotFoundException(Long id) {
            super("ProjectMember id[" + id + "] is not found");
        }
    }
}
