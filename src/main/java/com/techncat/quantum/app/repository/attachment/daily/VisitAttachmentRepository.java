package com.techncat.quantum.app.repository.attachment.daily;

import com.techncat.quantum.app.model.attachment.daily.VisitAttachment;
import com.techncat.quantum.app.model.daily.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitAttachmentRepository extends JpaRepository<VisitAttachment, Long> {
    List<VisitAttachment> findAllByVisit(Visit visit);
}
