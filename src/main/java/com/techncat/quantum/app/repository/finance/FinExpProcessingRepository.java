package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpProcessing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpProcessingRepository extends JpaRepository<ExpProcessing, Long> {
    ExpProcessing findFirstByExp(Exp exp);
}
