package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;

import java.math.BigDecimal;
import java.util.Date;

public class SocialFundVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private People people;

    private String fund_account_no;
    private String fund_source;
    private String remark;

    private BigDecimal personal_payment;
    private BigDecimal institutional_payment;
    private BigDecimal base_amount;
    private BigDecimal ratio_of_institutional_payment;
    private BigDecimal amount;
    private Integer month;

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

    public String getFund_account_no() {
        return fund_account_no;
    }

    public void setFund_account_no(String fund_account_no) {
        this.fund_account_no = fund_account_no;
    }

    public String getFund_source() {
        return fund_source;
    }

    public void setFund_source(String fund_source) {
        this.fund_source = fund_source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getPersonal_payment() {
        return personal_payment;
    }

    public void setPersonal_payment(BigDecimal personal_payment) {
        this.personal_payment = personal_payment;
    }

    public BigDecimal getInstitutional_payment() {
        return institutional_payment;
    }

    public void setInstitutional_payment(BigDecimal institutional_payment) {
        this.institutional_payment = institutional_payment;
    }

    public BigDecimal getBase_amount() {
        return base_amount;
    }

    public void setBase_amount(BigDecimal base_amount) {
        this.base_amount = base_amount;
    }

    public BigDecimal getRatio_of_institutional_payment() {
        return ratio_of_institutional_payment;
    }

    public void setRatio_of_institutional_payment(BigDecimal ratio_of_institutional_payment) {
        this.ratio_of_institutional_payment = ratio_of_institutional_payment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
