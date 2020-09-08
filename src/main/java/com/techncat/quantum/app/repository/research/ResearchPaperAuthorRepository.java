package com.techncat.quantum.app.repository.research;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.PaperAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResearchPaperAuthorRepository extends JpaRepository<PaperAuthor, Long> {
    List<PaperAuthor> findAllByPeople(People people);
}
