package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Patent;

import java.util.Date;

public class PatentVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String applicantJson;
    private String title;
    @ValueType("enumerated")
    private Patent.Type type;
    @ValueType("enumerated")
    private Patent.Status status;
    private Date apply_date;
    private Date approve_date;
    private String apply_no;
    private String patent_no;
    private Boolean is_pct;
    private Integer inventor_rank;

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

    public People getApplicant() {
        return applicant;
    }

    public void setApplicant(People applicant) {
        this.applicant = applicant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Patent.Type getType() {
        return type;
    }

    public void setType(Patent.Type type) {
        this.type = type;
    }

    public Patent.Status getStatus() {
        return status;
    }

    public void setStatus(Patent.Status status) {
        this.status = status;
    }

    public Date getApply_date() {
        return apply_date;
    }

    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
    }

    public Date getApprove_date() {
        return approve_date;
    }

    public void setApprove_date(Date approve_date) {
        this.approve_date = approve_date;
    }

    public String getApply_no() {
        return apply_no;
    }

    public void setApply_no(String apply_no) {
        this.apply_no = apply_no;
    }

    public String getPatent_no() {
        return patent_no;
    }

    public void setPatent_no(String patent_no) {
        this.patent_no = patent_no;
    }

    public Boolean getIs_pct() {
        return is_pct;
    }

    public void setIs_pct(Boolean is_pct) {
        this.is_pct = is_pct;
    }

    public Integer getInventor_rank() {
        return inventor_rank;
    }

    public void setInventor_rank(Integer inventor_rank) {
        this.inventor_rank = inventor_rank;
    }
}
