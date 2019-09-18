package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeoplePostdoctoral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeoplePostdoctoralRepository extends JpaRepository<PeoplePostdoctoral, Long> {
    PeoplePostdoctoral findByPeople(People people);

}
