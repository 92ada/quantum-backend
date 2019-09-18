package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleStudentRepository extends JpaRepository<PeopleStudent, Long> {
    PeopleStudent findByPeople(People people);
}
