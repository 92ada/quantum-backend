package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleResearcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleResearcherRepository extends JpaRepository<PeopleResearcher, Long> {
    PeopleResearcher findByPeople(People people);

}
