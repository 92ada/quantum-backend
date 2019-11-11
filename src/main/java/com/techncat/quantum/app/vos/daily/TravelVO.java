package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.daily.Travel;

import java.math.BigDecimal;
import java.util.Date;

public class TravelVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String travelerJson;
    @ValueType("enumerated")
    private Travel.Type type;
    private BigDecimal budget;
    private Date start_date;
    private Date end_date;

    @ValueType("enumerated")
    private Travel.identity_type identity_type;
    private String identity_no;

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

    public String getTravelerJson() {
        return travelerJson;
    }

    public void setTravelerJson(String travelerJson) {
        this.travelerJson = travelerJson;
    }

    public Travel.Type getType() {
        return type;
    }

    public void setType(Travel.Type type) {
        this.type = type;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Travel.identity_type getIdentity_type() {
        return identity_type;
    }

    public void setIdentity_type(Travel.identity_type identity_type) {
        this.identity_type = identity_type;
    }

    public String getIdentity_no() {
        return identity_no;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }
}
