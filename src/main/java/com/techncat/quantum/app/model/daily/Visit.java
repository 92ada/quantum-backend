package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit {
    public enum Status {
        unsubmitted, in_progress, approved
    }
    public enum IdentityType {
        id_card, passport
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String name;
    private Status approval_status;
    private String remark;
    private String visitor_institution;
    private String job_title;
    @ManyToOne
    @JoinColumn(name = "receptionist_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People receptionist;
    @Column(columnDefinition="text")
    private String receptionistJson; // {name: xxx, sid: xxx, id: xxx}
    private IdentityType identity_type;
    private String identity_no;
    private String phone_no;
    private String email;
    private String accommodation;
    private Boolean needs_pick_up;

    @Column(precision=10, scale=2)
    private BigDecimal expenditure;
    @Column(precision=10, scale=2)
    private BigDecimal budget;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getApproval_status() {
        return approval_status;
    }

    public void setApproval_status(Status approval_status) {
        this.approval_status = approval_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVisitor_institution() {
        return visitor_institution;
    }

    public void setVisitor_institution(String visitor_institution) {
        this.visitor_institution = visitor_institution;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public People getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(People receptionist) {
        this.receptionist = receptionist;
    }

    public IdentityType getIdentity_type() {
        return identity_type;
    }

    public void setIdentity_type(IdentityType identity_type) {
        this.identity_type = identity_type;
    }

    public String getIdentity_no() {
        return identity_no;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public Boolean getNeeds_pick_up() {
        return needs_pick_up;
    }

    public void setNeeds_pick_up(Boolean needs_pick_up) {
        this.needs_pick_up = needs_pick_up;
    }

    public BigDecimal getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(BigDecimal expenditure) {
        this.expenditure = expenditure;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getReceptionistJson() {
        return receptionistJson;
    }

    public void setReceptionistJson(String receptionistJson) {
        this.receptionistJson = receptionistJson;
    }
}
