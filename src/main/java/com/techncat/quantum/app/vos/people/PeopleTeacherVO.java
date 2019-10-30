package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleTeacher;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class PeopleTeacherVO {
    // detail
    private String positionTitle;
    private String job;
    private String socialJob;
    private String achievements;
    private Boolean isPhdMentor;
    private Boolean isMasterMentor;
    private Boolean isUnionMember;
    private String salaryCardNo;
    private String bank;
    private String contractNo;
    private Date contractStartDate;
    private Date contractEndDate;
    private BigDecimal annualSalary;
    private BigDecimal monthlySalary;
    private BigDecimal housingSubsidy;

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

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public BigDecimal getHousingSubsidy() {
        return housingSubsidy;
    }

    public void setHousingSubsidy(BigDecimal housingSubsidy) {
        this.housingSubsidy = housingSubsidy;
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
}
