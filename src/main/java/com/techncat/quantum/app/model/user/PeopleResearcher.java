package com.techncat.quantum.app.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people_researcher")
public class PeopleResearcher {
    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String positionTitle;
    private String job;

    @Column(columnDefinition="text")
    private String socialJob;
    @Column(columnDefinition="text")
    private String achievements;

    private boolean isPhdMentor;
    private boolean isMasterMentor;
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
