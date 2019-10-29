package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyVisitRepository extends JpaRepository<Visit, Long> {
}
