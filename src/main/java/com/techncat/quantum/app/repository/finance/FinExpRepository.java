package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FinExpRepository extends JpaRepository<Exp, Long> {
    Exp findFirstById(@Param("id") Long id);
}
