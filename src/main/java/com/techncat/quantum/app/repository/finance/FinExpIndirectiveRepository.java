package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpIndirective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpIndirectiveRepository extends JpaRepository<ExpIndirective, Long> {
    ExpIndirective findFirstByExp(Exp exp);
}
