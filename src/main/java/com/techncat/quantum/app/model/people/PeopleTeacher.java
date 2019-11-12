package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people_teacher")
public class PeopleTeacher {
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

    private Float annual_salary;
    private Float monthly_salary;
    private Float housing_subsidy;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getPosition_title() {
        return position_title;
    }

    public void setPosition_title(String position_title) {
        this.position_title = position_title;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSocial_job() {
        return social_job;
    }

    public void setSocial_job(String social_job) {
        this.social_job = social_job;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public Boolean getIs_phd_mentor() {
        return is_phd_mentor;
    }

    public void setIs_phd_mentor(Boolean is_phd_mentor) {
        this.is_phd_mentor = is_phd_mentor;
    }

    public Boolean getIs_master_mentor() {
        return is_master_mentor;
    }

    public void setIs_master_mentor(Boolean is_master_mentor) {
        this.is_master_mentor = is_master_mentor;
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

    public Float getAnnual_salary() {
        return annual_salary;
    }

    public void setAnnual_salary(Float annual_salary) {
        this.annual_salary = annual_salary;
    }

    public Float getMonthly_salary() {
        return monthly_salary;
    }

    public void setMonthly_salary(Float monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public Float getHousing_subsidy() {
        return housing_subsidy;
    }

    public void setHousing_subsidy(Float housing_subsidy) {
        this.housing_subsidy = housing_subsidy;
    }
}
