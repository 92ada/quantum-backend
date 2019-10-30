package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;

import java.math.BigDecimal;
import java.util.Date;

public class ExpLaborVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String category;
    private String matter;
    private BigDecimal standard;
    private Integer days;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public BigDecimal getStandard() {
        return standard;
    }

    public void setStandard(BigDecimal standard) {
        this.standard = standard;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getHandlerJson() {
        return handlerJson;
    }

    public void setHandlerJson(String handlerJson) {
        this.handlerJson = handlerJson;
    }
}
