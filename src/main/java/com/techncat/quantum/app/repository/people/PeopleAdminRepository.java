package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleAdminRepository extends JpaRepository<PeopleAdmin, Long> {
    PeopleAdmin findByPeople(People people);
}
