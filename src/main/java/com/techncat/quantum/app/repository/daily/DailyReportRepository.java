package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DailyReportRepository extends JpaRepository<Report, Long> {
    Page<Report> findAllByTimeBetweenAndInviter_IdIn(Date start, Date end, List<Long> peopleIds, Pageable pageable);
    Page<Report> findAllByInviter_IdIn(List<Long> peopleIds, Pageable pageable);

}
