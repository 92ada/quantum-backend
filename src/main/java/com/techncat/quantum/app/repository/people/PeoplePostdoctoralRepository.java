package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeoplePostdoctoral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeoplePostdoctoralRepository extends JpaRepository<PeoplePostdoctoral, Long> {
    PeoplePostdoctoral findByPeople(People people);
}
