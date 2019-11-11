package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "social_funds")
public class SocialFund {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;
    @Column(columnDefinition="text")
    private String people_json;

    private String fund_account_no;
    private String fund_source;
    private String remark;

    @Column(precision=10, scale=2)
    private BigDecimal personal_payment;
    @Column(precision=10, scale=2)
    private BigDecimal institutional_payment;
    @Column(precision=10, scale=2)
    private BigDecimal base_amount;
    @Column(precision=10, scale=2)
    private BigDecimal ratio_of_institutional_payment;
    @Column(precision=10, scale=2)
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

    public String getpeople_json() {
        return people_json;
    }

    public void setpeople_json(String people_json) {
        this.people_json = people_json;
    }
}
