package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.PeopleLab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleLabRepository extends JpaRepository<PeopleLab, Long> {
    List<PeopleLab> findAllByLabIdIn(List<Long> labIds);

    PeopleLab findFirstByPeopleIdAndLabId(@Param("peopleId") Long peopleId, @Param("labId") Long labId);
}
