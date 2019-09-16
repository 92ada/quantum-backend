package com.techncat.quantum.app.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people_admin")
public class PeopleAdmin {
    private Date updateAt;
    private Date createdAt;

    @Id
    private Long people_id;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private boolean isUnionMember;
    private String salaryCardNo;
    private String bank;
    private String contractNo;
    private Date contractStartDate;
    private Date contractEndDate;

    private float annualSalary;
    private float monthlySalary;
    private float housingSubsidy;
}
