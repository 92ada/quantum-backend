package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Reward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ResearchRewardRepository extends JpaRepository<Reward, Long> {
    Page<Reward> findAllByTitleLike(
            @Param("title") String title,
            Pageable pageable);
}
