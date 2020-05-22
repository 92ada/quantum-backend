package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DailyReportRepository extends JpaRepository<Report, Long> {
    Page<Report> findAllByTimeBetween(Date start, Date end, Pageable pageable);
    Page<Report> findAll(Pageable pageable);

}
