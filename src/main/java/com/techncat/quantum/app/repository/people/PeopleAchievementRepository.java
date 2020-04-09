package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.Achievement;
import com.techncat.quantum.app.model.people.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleAchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findAllByPeople(People people);

    Achievement findFirstById(Long id);

    void deleteAllByPeople(People people);

    void deleteAllByPeopleAndId(People people, @Param("id") Long id);
}
