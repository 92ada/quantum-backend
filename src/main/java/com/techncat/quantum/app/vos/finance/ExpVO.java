package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.finance.*;
import com.techncat.quantum.app.model.people.Lab;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/labs/options")
    private Lab lab;

    private Exp.Type type;
    private Date date;
    private String reservation_no;
    private BigDecimal amount;
    private Integer document_month;
    private String document_no;
    private String remark;

    private ExpConference expConference;
    private ExpConsultation expConsultation;
    private ExpEquipment expEquipment;
    private ExpIndirective expIndirective;
    private ExpInternational expInternational;
    private ExpLabor expLabor;
    private ExpMaterial expMaterial;
    private ExpOther expOther;
    private ExpProcessing expProcessing;
    private ExpPublication expPublication;
    private ExpTravel expTravel;

    public ExpVO(Exp exp) {
        BeanUtils.copyProperties(exp, this);
    }

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

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public Exp.Type getType() {
        return type;
    }

    public void setType(Exp.Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReservation_no() {
        return reservation_no;
    }

    public void setReservation_no(String reservation_no) {
        this.reservation_no = reservation_no;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getDocument_month() {
        return document_month;
    }

    public void setDocument_month(Integer document_month) {
        this.document_month = document_month;
    }

    public String getDocument_no() {
        return document_no;
    }

    public void setDocument_no(String document_no) {
        this.document_no = document_no;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ExpConference getExpConference() {
        return expConference;
    }

    public void setExpConference(ExpConference expConference) {
        this.expConference = expConference;
    }

    public ExpConsultation getExpConsultation() {
        return expConsultation;
    }

    public void setExpConsultation(ExpConsultation expConsultation) {
        this.expConsultation = expConsultation;
    }

    public ExpEquipment getExpEquipment() {
        return expEquipment;
    }

    public void setExpEquipment(ExpEquipment expEquipment) {
        this.expEquipment = expEquipment;
    }

    public ExpIndirective getExpIndirective() {
        return expIndirective;
    }

    public void setExpIndirective(ExpIndirective expIndirective) {
        this.expIndirective = expIndirective;
    }

    public ExpInternational getExpInternational() {
        return expInternational;
    }

    public void setExpInternational(ExpInternational expInternational) {
        this.expInternational = expInternational;
    }

    public ExpLabor getExpLabor() {
        return expLabor;
    }

    public void setExpLabor(ExpLabor expLabor) {
        this.expLabor = expLabor;
    }

    public ExpMaterial getExpMaterial() {
        return expMaterial;
    }

    public void setExpMaterial(ExpMaterial expMaterial) {
        this.expMaterial = expMaterial;
    }

    public ExpOther getExpOther() {
        return expOther;
    }

    public void setExpOther(ExpOther expOther) {
        this.expOther = expOther;
    }

    public ExpProcessing getExpProcessing() {
        return expProcessing;
    }

    public void setExpProcessing(ExpProcessing expProcessing) {
        this.expProcessing = expProcessing;
    }

    public ExpPublication getExpPublication() {
        return expPublication;
    }

    public void setExpPublication(ExpPublication expPublication) {
        this.expPublication = expPublication;
    }

    public ExpTravel getExpTravel() {
        return expTravel;
    }

    public void setExpTravel(ExpTravel expTravel) {
        this.expTravel = expTravel;
    }
}
