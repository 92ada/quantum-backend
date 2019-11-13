package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinExpMaterialRepository extends JpaRepository<ExpMaterial, Long> {
    ExpMaterial findFirstByExp(Exp exp);
}
