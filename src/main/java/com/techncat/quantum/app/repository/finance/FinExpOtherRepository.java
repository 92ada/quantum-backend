package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpOther;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpOtherRepository extends JpaRepository<ExpOther, Long> {
    ExpOther findFirstByExp(Exp exp);
}
