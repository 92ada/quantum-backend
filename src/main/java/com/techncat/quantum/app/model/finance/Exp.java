package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.Lab;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "exps", indexes = {
        @Index(name = "exps_expenditure_no", columnList = "expenditureNo", unique = false)
})
public class Exp {
    public enum Type {
        equipment, material, processing, travel, conference, international, publication, labor, consultation, other, indirective
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "lab_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Lab lab;

    private Type type;

    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(length = 45)
    private String expenditureNo;
    private String reservation_no;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
    private Integer document_month;
    private String document_no;
    private String remark;
    private String summary;


    @OneToOne
    @JoinColumn(name = "exp_conference_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpConference expConference;
    @OneToOne
    @JoinColumn(name = "exp_consultation_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpConsultation expConsultation;
    @OneToOne
    @JoinColumn(name = "exp_equipment_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpEquipment expEquipment;
    @OneToOne
    @JoinColumn(name = "exp_indirective_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpIndirective expIndirective;
    @OneToOne
    @JoinColumn(name = "exp_international_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpInternational expInternational;
    @OneToOne
    @JoinColumn(name = "exp_labor_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpLabor expLabor;
    @OneToOne
    @JoinColumn(name = "exp_material_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpMaterial expMaterial;
    @OneToOne
    @JoinColumn(name = "exp_other_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpOther expOther;
    @OneToOne
    @JoinColumn(name = "exp_processing_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpProcessing expProcessing;
    @OneToOne
    @JoinColumn(name = "exp_publication_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpPublication expPublication;
    @OneToOne
    @JoinColumn(name = "exp_travel_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ExpTravel expTravel;
}
