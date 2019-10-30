package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rewards")
public class Reward {
    public enum Level {
        national, provincial, local, other
    }
    public enum Grade {
        special, first, second, third, other
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "rewarded_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People rewarded;
    @Column(columnDefinition="text")
    private String rewardedJson;

    private String title;
    private String issue_institution;
    @Enumerated
    private Level level;
    @Enumerated
    private Grade grade;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
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

    public String getRewardedJson() {
        return rewardedJson;
    }

    public void setRewardedJson(String rewardedJson) {
        this.rewardedJson = rewardedJson;
    }
}
