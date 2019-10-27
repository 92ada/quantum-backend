package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleVisitor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class PeopleVisitorVO extends PeopleVO {
    // detail
    private String positionTitle;
    private String salaryCardNo;
    private String bank;
    private String citizenship;
    private String institution;
    private String researchDirection;
    private BigDecimal salary;
    private String remark;

    public PeopleVisitorVO(People people, PeopleVisitor peopleVisitor) {
        super(people);
        copyProperties(peopleVisitor);
    }

    private void copyProperties(PeopleVisitor peopleVisitor) {
        Long id = this.getId();
        Date createdAt = this.getCreatedAt();
        Date updatedAt = this.getUpdateAt();
        BeanUtils.copyProperties(peopleVisitor, this);
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

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getResearchDirection() {
        return researchDirection;
    }

    public void setResearchDirection(String researchDirection) {
        this.researchDirection = researchDirection;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
