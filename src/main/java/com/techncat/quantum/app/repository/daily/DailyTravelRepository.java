package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DailyTravelRepository extends JpaRepository<Travel, Long> {
    Page<Travel> findAllByStartDateBetweenAndTraveler_IdIn(Date start, Date end, List<Long> peopleIds, Pageable pageable);
    Page<Travel> findAllByTraveler_IdIn(List<Long> peopleIds, Pageable pageable);
}
