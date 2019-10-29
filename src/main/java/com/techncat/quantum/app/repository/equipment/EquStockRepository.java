package com.techncat.quantum.app.repository.equipment;

import com.techncat.quantum.app.model.equipment.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquStockRepository extends JpaRepository<Stock, Long> {
}
