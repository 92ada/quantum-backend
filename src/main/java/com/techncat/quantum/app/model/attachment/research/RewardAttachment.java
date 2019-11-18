package com.techncat.quantum.app.model.attachment.research;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.research.Reward;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reward_attachments")
public class RewardAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reward_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Reward reward;

    @ManyToOne
    @JoinColumn(name = "attachment_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Attachment attachment;
}
