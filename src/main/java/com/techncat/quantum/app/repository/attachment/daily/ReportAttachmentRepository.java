package com.techncat.quantum.app.repository.attachment.daily;

import com.techncat.quantum.app.model.attachment.daily.ReportAttachment;
import com.techncat.quantum.app.model.daily.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportAttachmentRepository extends JpaRepository<ReportAttachment, Long> {
    List<ReportAttachment> findAllByReport(Report report);
}
