package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DailyTravelRepository extends JpaRepository<Travel, Long> {
    Page<Travel> findAllByTraveler_NameLikeAndStartDateBetween(String word, Date start, Date end, Pageable pageable);
    Page<Travel> findAllByTraveler_NameLike(String word, Pageable pageable);
}
