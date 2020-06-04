package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResearchProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    List<ProjectMember> findAllByProject(Project project);

    ProjectMember findFirstById(Long id);

    void deleteAllByProject(Project project);

    void deleteAllByProjectAndId(Project project, @Param("id") Long id);
}
