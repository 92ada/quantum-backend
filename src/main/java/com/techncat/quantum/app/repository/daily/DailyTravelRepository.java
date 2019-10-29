package com.techncat.quantum.app.repository.daily;

import com.techncat.quantum.app.model.daily.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTravelRepository extends JpaRepository<Travel, Long> {
}
