package com.techncat.quantum.app.model.attachment.daily;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.daily.Visit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "visit_attachments")
public class VisitAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visit_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Visit visit;

    @ManyToOne
    @JoinColumn(name = "attachment_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Attachment attachment;
}
