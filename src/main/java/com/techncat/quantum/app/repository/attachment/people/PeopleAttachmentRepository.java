package com.techncat.quantum.app.repository.attachment.people;

import com.techncat.quantum.app.model.attachment.people.PeopleAttachment;
import com.techncat.quantum.app.model.people.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleAttachmentRepository extends JpaRepository<PeopleAttachment, Long> {
    List<PeopleAttachment> findAllByPeople(People people);
}
