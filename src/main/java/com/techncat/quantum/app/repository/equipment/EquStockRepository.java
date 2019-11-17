package com.techncat.quantum.app.repository.equipment;

import com.techncat.quantum.app.model.equipment.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquStockRepository extends JpaRepository<Stock, Long> {
    Page<Stock> findAll(Pageable pageable);

    List<Stock> findAll();

    Page<Stock> findAllByTitleLike(@Param("title") String title, Pageable pageable);

    List<Stock> findAllByTitleLike(@Param("title") String title);

}
