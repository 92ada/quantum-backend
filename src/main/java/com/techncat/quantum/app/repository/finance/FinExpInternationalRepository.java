package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpInternational;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpInternationalRepository extends JpaRepository<ExpInternational, Long> {
    ExpInternational findFirstByExp(Exp exp);
}
