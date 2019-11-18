package com.techncat.quantum.app.repository.attachment.research;

import com.techncat.quantum.app.model.attachment.research.ProjectAttachment;
import com.techncat.quantum.app.model.research.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectAttachmentRepository extends JpaRepository<ProjectAttachment, Long> {
    List<ProjectAttachment> findAllByProject(Project project);
}
