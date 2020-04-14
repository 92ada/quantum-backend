package com.techncat.quantum.app.model.finance;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "exp_processings")
public class ExpProcessing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    private String subject;
    private String content;
}
