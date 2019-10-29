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
    private Integer document_month;
    private String document_no;
    private String remark;

    private ExpConference expConference;
    private ExpConsultation expConsultation;
    private ExpEquipment expEquipment;
    private ExpIndirective expIndirective;
    private ExpInternational expInternational;
    private ExpLabor expLabor;
    private ExpMaterial expMaterial;
    private ExpOther expOther;
    private ExpProcessing expProcessing;
    private ExpPublication expPublication;
    private ExpTravel expTravel;
}
