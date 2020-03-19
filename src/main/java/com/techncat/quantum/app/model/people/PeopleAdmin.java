package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "people_admin")
public class PeopleAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date updateAt;
    private Date createdAt;

    private Boolean is_union_member;
    private String salary_card_no;
    private String bank;
    private String contract_no;
    @Temporal(TemporalType.DATE)
    private Date contract_start_date;
    @Temporal(TemporalType.DATE)
    private Date contract_end_date;

    @Column(precision = 10, scale = 2)
    private BigDecimal annual_salary;
    @Column(precision = 10, scale = 2)
    private BigDecimal monthly_salary;
    @Column(precision = 10, scale = 2)
    private BigDecimal housing_subsidy;
}
