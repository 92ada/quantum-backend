package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchPatentRepository extends JpaRepository<Patent, Long> {
}
