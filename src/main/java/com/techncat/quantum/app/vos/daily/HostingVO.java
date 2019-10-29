package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.annotation.ValueType;

import java.util.Date;

public class HostingVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String inviterJson;
    private Date time;
    private String title;
    private String site;
    private Boolean is_reimbursement;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Boolean getIs_reimbursement() {
        return is_reimbursement;
    }

    public void setIs_reimbursement(Boolean is_reimbursement) {
        this.is_reimbursement = is_reimbursement;
    }
}
