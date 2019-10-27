package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "social_funds")
public class SocialFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String fund_account_no;
    private String fund_source;
    private String remark;

    private BigDecimal personal_payment;
    private BigDecimal institutional_payment;
    private BigDecimal base_amount;
    private BigDecimal ratio_of_institutional_payment;
    private BigDecimal amount;
    private int month;
}
