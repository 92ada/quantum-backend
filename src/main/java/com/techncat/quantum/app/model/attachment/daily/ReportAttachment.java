package com.techncat.quantum.app.model.attachment.daily;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.daily.Report;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "report_attachments")
public class ReportAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Report report;

    @ManyToOne
    @JoinColumn(name = "attachment_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Attachment attachment;
}
