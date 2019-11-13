package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpPublication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpPublicationRepository extends JpaRepository<ExpPublication, Long> {
    ExpPublication findFirstByExp(Exp exp);
}
