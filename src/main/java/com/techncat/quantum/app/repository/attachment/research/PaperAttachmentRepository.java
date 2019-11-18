package com.techncat.quantum.app.repository.attachment.research;

import com.techncat.quantum.app.model.attachment.research.PaperAttachment;
import com.techncat.quantum.app.model.research.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperAttachmentRepository extends JpaRepository<PaperAttachment, Long> {
    List<PaperAttachment> findAllByPaper(Paper paper);
}
