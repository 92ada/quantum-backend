package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleResearcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleResearcherRepository extends JpaRepository<PeopleResearcher, Long> {
    PeopleResearcher findByPeople(People people);

}
