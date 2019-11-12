package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ResearchProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findAllByTitleLike(
            @Param("title") String title,
            Pageable pageable);
}
