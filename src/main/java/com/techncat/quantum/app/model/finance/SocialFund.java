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
@Table(name = "social_funds")
public class SocialFund {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object peopleJson;

    private String fund_account_no;
    private String fund_source;
    private String remark;

    @Column(precision = 10, scale = 2)
    private BigDecimal personal_payment;
    @Column(precision = 10, scale = 2)
    private BigDecimal institutional_payment;
    @Column(precision = 10, scale = 2)
    private BigDecimal base_amount;
    @Column(precision = 10, scale = 2)
    private BigDecimal ratio_of_institutional_payment;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    @Temporal(TemporalType.DATE)
    private Date date;
}
