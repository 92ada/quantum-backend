package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FinExp_Repository extends JpaRepository<Exp, Long> {
    Exp findFirstById(@Param("id") Long id);

    Page<Exp> findAllByType(@Param("type") Exp.Type type, Pageable pageable);

    Page<Exp> findAllByTypeAndDateBetween(@Param("type") Exp.Type type, Date start, Date end, Pageable pageable);

    Page<Exp> findAllByDateBetween(Date start, Date end, Pageable pageable);

    List<Exp> findAllByDateBetween(Date start, Date end);
}
