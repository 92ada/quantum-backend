package com.techncat.quantum.app.model.attachment.daily;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.daily.Hosting;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hosting_attachments")
public class HostingAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "hosting_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Hosting hosting;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "attachment_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Attachment attachment;
}
