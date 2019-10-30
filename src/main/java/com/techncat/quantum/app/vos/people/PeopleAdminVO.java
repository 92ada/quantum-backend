package com.techncat.quantum.app.vos.people;

import java.math.BigDecimal;
import java.util.Date;

public class PeopleAdminVO {
    // detail
    private Boolean isUnionMember;
    private String salaryCardNo;
    private String bank;
    private String contractNo;
    private Date contractStartDate;
    private Date contractEndDate;
    private BigDecimal annualSalary;
    private BigDecimal monthlySalary;
    private BigDecimal housingSubsidy;

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
