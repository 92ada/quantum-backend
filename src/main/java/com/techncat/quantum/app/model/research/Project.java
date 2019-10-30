package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    public enum Category {
        applying, approved
    }
    public enum WayOfTaking {
        lead, cooperate
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String type; // 可能是枚举，不清楚选项
    @Enumerated
    private Category category;
    @ManyToOne
    @JoinColumn(name = "leader_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People leader;
    @Column(columnDefinition="text")
    private String leaderJson;

    private Date start_date;
    private Date end_date;
    private WayOfTaking way_of_taking;
    @Column(precision = 10, scale = 2)
    private BigDecimal approved_funds;

    @ManyToMany
    @JoinColumn(name = "member_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<People> member;
    @Column(columnDefinition="text")
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public WayOfTaking getWay_of_taking() {
        return way_of_taking;
    }

    public void setWay_of_taking(WayOfTaking way_of_taking) {
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

    public String getLeaderJson() {
        return leaderJson;
    }

    public void setLeaderJson(String leaderJson) {
        this.leaderJson = leaderJson;
    }

    public String getMembersJson() {
        return membersJson;
    }

    public void setMembersJson(String membersJson) {
        this.membersJson = membersJson;
    }
}
