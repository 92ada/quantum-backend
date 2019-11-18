package com.techncat.quantum.app.repository.attachment;

import com.techncat.quantum.app.model.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
