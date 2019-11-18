package com.techncat.quantum.app.model.attachment.people;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "people_attachments")
public class PeopleAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    @ManyToOne
    @JoinColumn(name = "attachment_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Attachment attachment;
}
