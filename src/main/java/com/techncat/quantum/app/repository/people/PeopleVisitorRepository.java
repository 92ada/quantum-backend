package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleVisitorRepository extends JpaRepository<PeopleVisitor, Long> {
    PeopleVisitor findByPeople(People people);
}
