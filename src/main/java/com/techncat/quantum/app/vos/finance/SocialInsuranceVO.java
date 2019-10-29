package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;

import java.math.BigDecimal;
import java.util.Date;

public class SocialInsuranceVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private People people;

    private BigDecimal receivable_total;
    private BigDecimal receivable_by_individual;
    private BigDecimal receivable_by_institution;
    private BigDecimal pension_base_amount;
    private BigDecimal pension_by_individual;
    private BigDecimal pension_by_institution;
    private BigDecimal medical_base_amount;
    private BigDecimal medical_by_individual;
    private BigDecimal medical_by_institution;
    private BigDecimal work_injury_base_amount;
    private BigDecimal work_injury_by_institution;
    private BigDecimal unemployment_base_amount;
    private BigDecimal unemployment_by_individual;
    private BigDecimal unemployment_by_institution;
    private BigDecimal fertility_base_amount;
    private BigDecimal fertility_by_institution;

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

    public BigDecimal getReceivable_total() {
        return receivable_total;
    }

    public void setReceivable_total(BigDecimal receivable_total) {
        this.receivable_total = receivable_total;
    }

    public BigDecimal getReceivable_by_individual() {
        return receivable_by_individual;
    }

    public void setReceivable_by_individual(BigDecimal receivable_by_individual) {
        this.receivable_by_individual = receivable_by_individual;
    }

    public BigDecimal getReceivable_by_institution() {
        return receivable_by_institution;
    }

    public void setReceivable_by_institution(BigDecimal receivable_by_institution) {
        this.receivable_by_institution = receivable_by_institution;
    }

    public BigDecimal getPension_base_amount() {
        return pension_base_amount;
    }

    public void setPension_base_amount(BigDecimal pension_base_amount) {
        this.pension_base_amount = pension_base_amount;
    }

    public BigDecimal getPension_by_individual() {
        return pension_by_individual;
    }

    public void setPension_by_individual(BigDecimal pension_by_individual) {
        this.pension_by_individual = pension_by_individual;
    }

    public BigDecimal getPension_by_institution() {
        return pension_by_institution;
    }

    public void setPension_by_institution(BigDecimal pension_by_institution) {
        this.pension_by_institution = pension_by_institution;
    }

    public BigDecimal getMedical_base_amount() {
        return medical_base_amount;
    }

    public void setMedical_base_amount(BigDecimal medical_base_amount) {
        this.medical_base_amount = medical_base_amount;
    }

    public BigDecimal getMedical_by_individual() {
        return medical_by_individual;
    }

    public void setMedical_by_individual(BigDecimal medical_by_individual) {
        this.medical_by_individual = medical_by_individual;
    }

    public BigDecimal getMedical_by_institution() {
        return medical_by_institution;
    }

    public void setMedical_by_institution(BigDecimal medical_by_institution) {
        this.medical_by_institution = medical_by_institution;
    }

    public BigDecimal getWork_injury_base_amount() {
        return work_injury_base_amount;
    }

    public void setWork_injury_base_amount(BigDecimal work_injury_base_amount) {
        this.work_injury_base_amount = work_injury_base_amount;
    }

    public BigDecimal getWork_injury_by_institution() {
        return work_injury_by_institution;
    }

    public void setWork_injury_by_institution(BigDecimal work_injury_by_institution) {
        this.work_injury_by_institution = work_injury_by_institution;
    }

    public BigDecimal getUnemployment_base_amount() {
        return unemployment_base_amount;
    }

    public void setUnemployment_base_amount(BigDecimal unemployment_base_amount) {
        this.unemployment_base_amount = unemployment_base_amount;
    }

    public BigDecimal getUnemployment_by_individual() {
        return unemployment_by_individual;
    }

    public void setUnemployment_by_individual(BigDecimal unemployment_by_individual) {
        this.unemployment_by_individual = unemployment_by_individual;
    }

    public BigDecimal getUnemployment_by_institution() {
        return unemployment_by_institution;
    }

    public void setUnemployment_by_institution(BigDecimal unemployment_by_institution) {
        this.unemployment_by_institution = unemployment_by_institution;
    }

    public BigDecimal getFertility_base_amount() {
        return fertility_base_amount;
    }

    public void setFertility_base_amount(BigDecimal fertility_base_amount) {
        this.fertility_base_amount = fertility_base_amount;
    }

    public BigDecimal getFertility_by_institution() {
        return fertility_by_institution;
    }

    public void setFertility_by_institution(BigDecimal fertility_by_institution) {
        this.fertility_by_institution = fertility_by_institution;
    }
}
