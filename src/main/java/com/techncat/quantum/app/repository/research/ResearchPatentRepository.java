package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Patent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ResearchPatentRepository extends JpaRepository<Patent, Long> {
    Page<Patent> findAllByTitleLike(
            @Param("title") String title,
            Pageable pageable);
}
