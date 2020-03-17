package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "social_insurances")
public class SocialInsurance {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private Date updateAt;
        private Date createdAt;

        @OneToOne
        @NotFound(action= NotFoundAction.IGNORE)
        @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
        private People people;


    @Temporal(TemporalType.DATE)
    private Date date;

    private String fund_source;

    @Column(precision = 10, scale = 2)
    private BigDecimal receivable_total;
    @Column(precision = 10, scale = 2)
    private BigDecimal receivable_by_individual;
    @Column(precision = 10, scale = 2)
    private BigDecimal receivable_by_institution;
    @Column(precision = 10, scale = 2)
    private BigDecimal pension_base_amount;
    @Column(precision = 10, scale = 2)
    private BigDecimal pension_by_individual;
    @Column(precision = 10, scale = 2)
    private BigDecimal pension_by_institution;
    @Column(precision = 10, scale = 2)
    private BigDecimal medical_base_amount;
    @Column(precision = 10, scale = 2)
    private BigDecimal medical_by_individual;
    @Column(precision = 10, scale = 2)
    private BigDecimal medical_by_institution;
    @Column(precision = 10, scale = 2)
    private BigDecimal work_injury_base_amount;
    @Column(precision = 10, scale = 2)
    private BigDecimal work_injury_by_institution;
    @Column(precision = 10, scale = 2)
    private BigDecimal unemployment_base_amount;
    @Column(precision = 10, scale = 2)
    private BigDecimal unemployment_by_individual;
    @Column(precision = 10, scale = 2)
    private BigDecimal unemployment_by_institution;
    @Column(precision = 10, scale = 2)
    private BigDecimal fertility_base_amount;
    @Column(precision = 10, scale = 2)
    private BigDecimal fertility_by_institution;
}
