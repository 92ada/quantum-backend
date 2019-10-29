package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchPaperRepository extends JpaRepository<Paper, Long> {
}
