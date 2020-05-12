package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Patent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResearchPatentRepository extends JpaRepository<Patent, Long> {
    Page<Patent> findAllByTitleLikeAndIdIn(
            @Param("title") String title,
            List<Long> longs, Pageable pageable);

    Page<Patent> findAllByIdIn(
            List<Long> longs, Pageable pageable);
}
