package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Reward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResearchRewardRepository extends JpaRepository<Reward, Long> {
    Page<Reward> findAllByTitleLikeAndRewarded_IdIn(
            @Param("title") String title,
            List<Long> peopleIds, Pageable pageable);

    Page<Reward> findAllByRewarded_IdIn(
            List<Long> peopleIds, Pageable pageable);
}
