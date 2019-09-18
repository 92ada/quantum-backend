package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleAdmin;
import com.techncat.quantum.app.model.user.PeopleResearcher;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class PeopleResearcherVO extends PeopleVO {
    // detail
    private String positionTitle;
    private String job;
    private String socialJob;
    private String achievements;
    private boolean isPhdMentor;
    private boolean isMasterMentor;
    private boolean isUnionMember;
    private String salaryCardNo;
    private String bank;
    private String contractNo;
    private Date contractStartDate;
    private Date contractEndDate;
    private BigDecimal annualSalary;
    private BigDecimal monthlySalary;
    private BigDecimal housingSubsidy;

    public PeopleResearcherVO(People people, PeopleResearcher peopleResearcher) {
        super(people);
        copyProperties(peopleResearcher);
    }

    private void copyProperties(PeopleResearcher peopleResearcher) {
        Long id = this.getId();
        Date createdAt = this.getCreatedAt();
        Date updatedAt = this.getUpdateAt();
        BeanUtils.copyProperties(peopleResearcher, this);
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setUpdateAt(updatedAt);
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

    public boolean isPhdMentor() {
        return isPhdMentor;
    }

    public void setPhdMentor(boolean phdMentor) {
        isPhdMentor = phdMentor;
    }

    public boolean isMasterMentor() {
        return isMasterMentor;
    }

    public void setMasterMentor(boolean masterMentor) {
        isMasterMentor = masterMentor;
    }

    public boolean isUnionMember() {
        return isUnionMember;
    }

    public void setUnionMember(boolean unionMember) {
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
}
