package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyReportRepository extends JpaRepository<Report, Long> {
}
