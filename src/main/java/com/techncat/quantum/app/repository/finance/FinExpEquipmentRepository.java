package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpEquipmentRepository extends JpaRepository<ExpEquipment, Long> {
    ExpEquipment findFirstByExp(Exp exp);
}
