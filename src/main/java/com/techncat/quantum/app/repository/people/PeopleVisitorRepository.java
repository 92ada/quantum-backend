package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.PeopleVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleVisitorRepository extends JpaRepository<PeopleVisitor, Long> {
}
