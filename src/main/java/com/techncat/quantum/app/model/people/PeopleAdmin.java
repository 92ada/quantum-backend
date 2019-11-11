package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "people_admin")
public class PeopleAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private Boolean is_union_member;
    private String salary_card_no;
    private String bank;
    private String contract_no;
    private Date contract_start_date;
    private Date contract_end_date;

    @Column(precision = 10, scale = 2)
    private BigDecimal annual_salary;
    @Column(precision = 10, scale = 2)
    private BigDecimal monthly_salary;
    @Column(precision = 10, scale = 2)
    private BigDecimal housing_subsidy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Boolean getIs_union_member() {
        return is_union_member;
    }

    public void setIs_union_member(Boolean is_union_member) {
        this.is_union_member = is_union_member;
    }

    public String getSalary_card_no() {
        return salary_card_no;
    }

    public void setSalary_card_no(String salary_card_no) {
        this.salary_card_no = salary_card_no;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getContract_no() {
        return contract_no;
    }

    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    public Date getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(Date contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public Date getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(Date contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public BigDecimal getAnnual_salary() {
        return annual_salary;
    }

    public void setAnnual_salary(BigDecimal annual_salary) {
        this.annual_salary = annual_salary;
    }

    public BigDecimal getMonthly_salary() {
        return monthly_salary;
    }

    public void setMonthly_salary(BigDecimal monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public BigDecimal getHousing_subsidy() {
        return housing_subsidy;
    }

    public void setHousing_subsidy(BigDecimal housing_subsidy) {
        this.housing_subsidy = housing_subsidy;
    }
}
