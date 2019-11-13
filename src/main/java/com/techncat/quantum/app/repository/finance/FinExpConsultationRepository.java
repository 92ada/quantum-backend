package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpConsultationRepository extends JpaRepository<ExpConsultation, Long> {
    ExpConsultation findFirstByExp(Exp exp);
}
