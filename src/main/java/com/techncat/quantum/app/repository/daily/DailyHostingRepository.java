package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Hosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyHostingRepository extends JpaRepository<Hosting, Long> {
}
