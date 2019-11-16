package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Visit;
import com.techncat.quantum.app.model.daily.VisitFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DailyVisitFlightRepository extends JpaRepository<VisitFlight, Long> {
    List<VisitFlight> findAllByVisit(Visit visit);

    VisitFlight findFirstById(@Param("id") Long id);

    void deleteAllByVisit(Visit visit);
}
