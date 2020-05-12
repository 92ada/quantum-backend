package com.techncat.quantum.app.repository.equipment;

import com.techncat.quantum.app.model.equipment.Purchasing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquPurchasingRepository extends JpaRepository<Purchasing, Long> {
    Page<Purchasing> findAll(Pageable pageable);

    Page<Purchasing> findAllByPi_IdIn(List<Long> peopleIds, Pageable pageable);

    List<Purchasing> findAll();

    Page<Purchasing> findAllByTitleLikeAndPi_IdIn(@Param("title") String title, List<Long> peopleIds, Pageable pageable);

    List<Purchasing> findAllByTitleLike(@Param("title") String title);
}
