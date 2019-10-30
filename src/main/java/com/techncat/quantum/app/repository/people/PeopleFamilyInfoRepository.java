package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.FamilyInfo;
import com.techncat.quantum.app.model.people.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleFamilyInfoRepository extends JpaRepository<FamilyInfo, Long> {
    List<FamilyInfo> findAllByPeople(People people);

    FamilyInfo findFirstById(@Param("id") Long id);
}
