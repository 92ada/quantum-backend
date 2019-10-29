package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.research.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchProjectRepository extends JpaRepository<Project, Long> {
}
