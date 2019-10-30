package com.techncat.quantum.app.vos.finance;

import java.util.Date;

public class ExpProcessingVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String subject;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
