package com.techncat.quantum.app.model.attachment.people;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "people_attachments")
public class PeopleAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "attachment_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Attachment attachment;
}
