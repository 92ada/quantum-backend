package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpConference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpConferenceRepository extends JpaRepository<ExpConference, Long> {
    ExpConference findFirstByExp(Exp exp);
}
