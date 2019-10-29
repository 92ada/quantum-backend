package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.VisitFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyVisitFlightRepository extends JpaRepository<VisitFlight, Long> {
}
