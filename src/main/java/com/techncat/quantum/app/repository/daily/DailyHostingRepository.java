package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Hosting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DailyHostingRepository extends JpaRepository<Hosting, Long> {
    Page<Hosting> findAllByTitleLike(String word, Pageable pageable);
    Page<Hosting> findAllByTitleLikeAndTimeBetween(String word, Date start, Date end, Pageable pageable);
}
