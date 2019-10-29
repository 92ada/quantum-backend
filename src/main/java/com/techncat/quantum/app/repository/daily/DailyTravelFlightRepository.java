package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.TravelFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTravelFlightRepository extends JpaRepository<TravelFlight, Long> {
}
