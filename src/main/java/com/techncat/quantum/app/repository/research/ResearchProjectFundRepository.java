package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.ProjectFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResearchProjectFundRepository extends JpaRepository<ProjectFund, Long> {
    List<ProjectFund> findAllByProject(Project project);

    ProjectFund findFirstById(Long id);

    void deleteAllByProject(Project project);

    void deleteAllByProjectAndId(Project project, @Param("id") Long id);
}
