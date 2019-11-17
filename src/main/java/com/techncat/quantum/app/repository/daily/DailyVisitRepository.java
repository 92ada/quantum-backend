package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DailyVisitRepository extends JpaRepository<Visit, Long> {
    Page<Visit> findAllByTimeBetween(Date start, Date end, Pageable pageable);
}
