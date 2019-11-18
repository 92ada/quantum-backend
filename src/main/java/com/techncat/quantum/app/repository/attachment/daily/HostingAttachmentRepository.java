package com.techncat.quantum.app.repository.attachment.daily;

import com.techncat.quantum.app.model.attachment.daily.HostingAttachment;
import com.techncat.quantum.app.model.daily.Hosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HostingAttachmentRepository extends JpaRepository<HostingAttachment, Long> {
    List<HostingAttachment> findAllByHosting(Hosting hosting);
}
