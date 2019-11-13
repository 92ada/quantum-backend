package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpTravel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpTravelRepository extends JpaRepository<ExpTravel, Long> {
    ExpTravel findFirstByExp(Exp exp);
}
