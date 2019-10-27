package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.Lab;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "exps")
public class Exp {
    public enum Type {
        equipment, material, processing, travel, conference, international, publication, labor, consultation, other, indirective
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "lab_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Lab lab;

    private Type type;
    private Date date;
    private String reservation_no;
    private BigDecimal amount;
    private int document_month;
    private String document_no;
    private String remark;

    private ExpEquipment expEquipment;
}
