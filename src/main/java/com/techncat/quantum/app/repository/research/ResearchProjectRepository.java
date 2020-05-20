package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResearchProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findAllByTitleLikeAndLeader_IdIn(
            @Param("title") String title,
            List<Long> peopleIds, Pageable pageable);

    Page<Project> findAllByLeader_IdIn(
            @Param("title") List<Long> title,
            Pageable pageable);

    Optional<Project> findFirstByTitle(String title);
}
