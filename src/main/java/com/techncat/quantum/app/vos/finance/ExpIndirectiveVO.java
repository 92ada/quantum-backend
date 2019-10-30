package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;

import java.util.Date;

public class ExpIndirectiveVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String subject;
    private String matter;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getUpdateAt() {
        return updateAt;
    }

    @Override
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getHandlerJson() {
        return handlerJson;
    }

    public void setHandlerJson(String handlerJson) {
        this.handlerJson = handlerJson;
    }
}
