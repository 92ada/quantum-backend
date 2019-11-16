package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Travel;
import com.techncat.quantum.app.model.daily.TravelFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DailyTravelFlightRepository extends JpaRepository<TravelFlight, Long> {
    List<TravelFlight> findAllByTravel(Travel travel);

    TravelFlight findFirstById(@Param("id") Long id);

    void deleteAllByTravel(Travel travel);
}
