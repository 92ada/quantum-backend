package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Paper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResearchPaperRepository extends JpaRepository<Paper, Long> {
    Page<Paper> findAllByTitleLikeAndIdIn(
            @Param("title") String title,
            List<Long> longs, Pageable pageable);

    Page<Paper> findAllByTitleLike(
            @Param("title") String title,
            Pageable pageable);

    Page<Paper> findAllByIdIn(
            List<Long> longs, Pageable pageable);

    Optional<Paper> findFirstByTitle(String title);
}
