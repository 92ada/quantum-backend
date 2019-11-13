package com.techncat.quantum.app.model.finance;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "exp_labors")
public class ExpLabor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

//    @OneToOne
//    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private Exp exp;

    private String category;
    private String matter;
    @Column(precision = 10, scale = 2)
    private BigDecimal standard;
    private Integer days;

    @ManyToOne
    @JoinColumn(name = "handler_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People handler;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object handlerJson;
}
