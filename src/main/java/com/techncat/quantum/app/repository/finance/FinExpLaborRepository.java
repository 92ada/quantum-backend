package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpLabor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpLaborRepository extends JpaRepository<ExpLabor, Long> {
    ExpLabor findFirstByExp(Exp exp);
}
