package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.util.Date;

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

    private String positionTitle;
    private String job;

    @Column(columnDefinition="text")
    private String socialJob;
    @Column(columnDefinition="text")
    private String achievements;

    private Boolean isPhdMentor;
    private Boolean isMasterMentor;
    private Boolean isUnionMember;

    private String salaryCardNo;
    private String bank;
    private String contractNo;
    private Date contractStartDate;
    private Date contractEndDate;

    private Float annualSalary;
    private Float monthlySalary;
    private Float housingSubsidy;

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

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSocialJob() {
        return socialJob;
    }

    public void setSocialJob(String socialJob) {
        this.socialJob = socialJob;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public Boolean getIsPhdMentor() {
        return isPhdMentor;
    }

    public void setIsPhdMentor(Boolean phdMentor) {
        isPhdMentor = phdMentor;
    }

    public Boolean getIsMasterMentor() {
        return isMasterMentor;
    }

    public void setIsMasterMentor(Boolean masterMentor) {
        isMasterMentor = masterMentor;
    }

    public Boolean getIsUnionMember() {
        return isUnionMember;
    }

    public void setIsUnionMember(Boolean unionMember) {
        isUnionMember = unionMember;
    }

    public String getSalaryCardNo() {
        return salaryCardNo;
    }

    public void setSalaryCardNo(String salaryCardNo) {
        this.salaryCardNo = salaryCardNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Float getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Float annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Float getHousingSubsidy() {
        return housingSubsidy;
    }

    public void setHousingSubsidy(Float housingSubsidy) {
        this.housingSubsidy = housingSubsidy;
    }
}
