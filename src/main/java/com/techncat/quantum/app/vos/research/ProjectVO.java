package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Project;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class ProjectVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String type; // 可能是枚举，不清楚选项
    @ValueType("enumerated")
    private Project.Category category;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private String leaderJson;

    private Date start_date;
    private Date end_date;
    @ValueType("enumerated")
    private Project.WayOfTaking way_of_taking;
    private BigDecimal approved_funds;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private String membersJson;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Project.Category getCategory() {
        return category;
    }

    public void setCategory(Project.Category category) {
        this.category = category;
    }

    public People getLeader() {
        return leader;
    }

    public void setLeader(People leader) {
        this.leader = leader;
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

    public Project.WayOfTaking getWay_of_taking() {
        return way_of_taking;
    }

    public void setWay_of_taking(Project.WayOfTaking way_of_taking) {
        this.way_of_taking = way_of_taking;
    }

    public BigDecimal getApproved_funds() {
        return approved_funds;
    }

    public void setApproved_funds(BigDecimal approved_funds) {
        this.approved_funds = approved_funds;
    }

    public Set<People> getMember() {
        return member;
    }

    public void setMember(Set<People> member) {
        this.member = member;
    }
}
