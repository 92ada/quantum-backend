package com.techncat.quantum.app.repository.log;

import com.techncat.quantum.app.model.log.LogRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface LogRepository extends JpaRepository<LogRecord, Long> {
    Page<LogRecord> findAllByTimestampLessThanOrderByTimestampAsc(@Param("timestamp") Long timestamp, Pageable pageable);
}
