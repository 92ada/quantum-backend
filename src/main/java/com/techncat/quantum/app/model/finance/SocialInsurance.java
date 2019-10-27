package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "social_insurances")
public class SocialInsurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private BigDecimal receivable_total;
    private BigDecimal receivable_by_individual;
    private BigDecimal receivable_by_institution;
    private BigDecimal pension_base_amount;
    private BigDecimal pension_by_individual;
    private BigDecimal pension_by_institution;
    private BigDecimal medical_base_amount;
    private BigDecimal medical_by_individual;
    private BigDecimal medical_by_institution;
    private BigDecimal work_injury_base_amount;
    private BigDecimal work_injury_by_institution;
    private BigDecimal unemployment_base_amount;
    private BigDecimal unemployment_by_individual;
    private BigDecimal unemployment_by_institution;
    private BigDecimal fertility_base_amount;
    private BigDecimal fertility_by_institution;
}
