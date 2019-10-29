package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Reward;

import java.util.Date;

public class RewardVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private People rewarded;

    private String title;
    private String issue_institution;
    @ValueType("enumerated")
    private Reward.Level level;
    @ValueType("enumerated")
    private Reward.Grade grade;
    private Date date;
    private String remark;

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

    public People getRewarded() {
        return rewarded;
    }

    public void setRewarded(People rewarded) {
        this.rewarded = rewarded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssue_institution() {
        return issue_institution;
    }

    public void setIssue_institution(String issue_institution) {
        this.issue_institution = issue_institution;
    }

    public Reward.Level getLevel() {
        return level;
    }

    public void setLevel(Reward.Level level) {
        this.level = level;
    }

    public Reward.Grade getGrade() {
        return grade;
    }

    public void setGrade(Reward.Grade grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
