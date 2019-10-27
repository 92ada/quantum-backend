package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "people_admin")
public class PeopleAdmin {
    @Id
    private Long id;
    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private boolean isUnionMember;
    private String salaryCardNo;
    private String bank;
    private String contractNo;
    private Date contractStartDate;
    private Date contractEndDate;

    private BigDecimal annualSalary;
    private BigDecimal monthlySalary;
    private BigDecimal housingSubsidy;
}
