package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "people_researcher")
public class PeopleResearcher {
    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String position_title;
    private String job;

    @Column(columnDefinition="text")
    private String social_job;
    @Column(columnDefinition="text")
    private String achievements;

    private Boolean is_phd_mentor;
    private Boolean is_master_mentor;
    private Boolean is_union_member;

    private String salary_card_no;
    private String bank;
    private String contract_no;
    @Temporal(TemporalType.DATE)
    private Date contract_start_date;
    @Temporal(TemporalType.DATE)
    private Date contract_end_date;

    private BigDecimal annual_salary;
    private BigDecimal monthly_salary;
    private BigDecimal housing_subsidy;
}
