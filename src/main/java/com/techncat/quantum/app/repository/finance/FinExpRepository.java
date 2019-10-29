package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpRepository extends JpaRepository<Exp, Long> {
}
