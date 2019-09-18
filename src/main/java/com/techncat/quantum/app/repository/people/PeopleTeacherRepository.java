package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleTeacherRepository extends JpaRepository<PeopleTeacher, Long> {
    PeopleTeacher findByPeople(People people);
}
