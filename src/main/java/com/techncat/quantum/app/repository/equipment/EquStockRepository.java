package com.techncat.quantum.app.repository.equipment;

import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.model.people.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EquStockRepository extends JpaRepository<Stock, Long> {
    Page<Stock> findAllByTitleLike(String word, Pageable pageable);

    Page<Stock> findAllByAdmin_IdIn(List<Long> peopleIds, Pageable pageable);

    List<Stock> findAll();

    Page<Stock> findAllByTitleLikeAndAdmin_IdIn(@Param("title") String title, List<Long> peopleIds, Pageable pageable);

    List<Stock> findAllByTitleLike(@Param("title") String title);

    Optional<Stock> findFirstByTitle(String title);

    List<Stock> findAllByAdmin(People people);

}
