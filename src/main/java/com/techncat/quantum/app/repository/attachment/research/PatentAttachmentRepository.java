package com.techncat.quantum.app.repository.attachment.research;

import com.techncat.quantum.app.model.attachment.research.PatentAttachment;
import com.techncat.quantum.app.model.research.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatentAttachmentRepository extends JpaRepository<PatentAttachment, Long> {
    List<PatentAttachment> findAllByPatent(Patent patent);
}
