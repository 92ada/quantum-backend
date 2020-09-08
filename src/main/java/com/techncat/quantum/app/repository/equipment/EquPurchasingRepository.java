package com.techncat.quantum.app.repository.equipment;

import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.model.people.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EquPurchasingRepository extends JpaRepository<Purchasing, Long> {
    Page<Purchasing> findAllByTitleLike(String word, Pageable pageable);

    Page<Purchasing> findAllByPi_IdIn(List<Long> peopleIds, Pageable pageable);

    List<Purchasing> findAll();

    Page<Purchasing> findAllByTitleLikeAndPi_IdIn(@Param("title") String title, List<Long> peopleIds, Pageable pageable);

    List<Purchasing> findAllByTitleLike(@Param("title") String title);

    Optional<Purchasing> findFirstByTitle(String title);

    List<Purchasing> findAllByPiOrHandler(@Param("pi")People pi, @Param("handler")People handler);
}
