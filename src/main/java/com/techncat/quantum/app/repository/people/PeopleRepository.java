package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.user.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
