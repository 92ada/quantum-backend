package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
