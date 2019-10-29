package com.techncat.quantum.app.repository.equipment;

import com.techncat.quantum.app.model.equipment.Purchasing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquPurchasingRepository extends JpaRepository<Purchasing, Long> {
}
