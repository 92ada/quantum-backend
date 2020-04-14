package com.techncat.quantum.app.model.finance;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "exp_consultations")
public class ExpConsultation {
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
    private String matter;
    private String department;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "handler_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People handler;
    @Column(columnDefinition="json")
    @Convert(converter = JpaConverterJson.class)
    private Object handlerJson;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "payee_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People payee;
    @Column(columnDefinition="json")
    @Convert(converter = JpaConverterJson.class)
    private Object payeeJson;
}
