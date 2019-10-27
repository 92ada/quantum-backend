package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleAdminRepository extends JpaRepository<PeopleAdmin, Long> {
    PeopleAdmin findByPeople(People people);
}
