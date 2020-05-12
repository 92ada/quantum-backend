package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DailyVisitRepository extends JpaRepository<Visit, Long> {
    Page<Visit> findAllByTimeBetweenAndReceptionist_IdIn(Date start, Date end, List<Long> peopleIds, Pageable pageable);

    Page<Visit> findAllByReceptionist_IdIn(List<Long> peopleIds, PageRequest pageRequest);
}
