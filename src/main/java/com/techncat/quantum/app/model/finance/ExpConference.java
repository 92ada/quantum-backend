package com.techncat.quantum.app.model.finance;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "exp_conferences")
public class ExpConference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    private Date start_date;
    private Date end_date;
    private String place_of_participation;
    private Integer planned_attendance;
    private Integer actual_attendance;
    @Column(precision=10, scale=2)
    private BigDecimal budget;
    @Column(precision=10, scale=2)
    private BigDecimal actual_total_cost;
    @Column(precision=10, scale=2)
    private BigDecimal meeting_expenses;
    @Column(precision=10, scale=2)
    private BigDecimal transportation_expenses;
    @Column(precision=10, scale=2)
    private BigDecimal labor_expenses;

    @ManyToMany
    @JoinColumn(name = "officer_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<People> officer;
    @Column(columnDefinition="text")
    private String officersJson;

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

    public Exp getExp() {
        return exp;
    }

    public void setExp(Exp exp) {
        this.exp = exp;
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

    public String getPlace_of_participation() {
        return place_of_participation;
    }

    public void setPlace_of_participation(String place_of_participation) {
        this.place_of_participation = place_of_participation;
    }

    public Integer getPlanned_attendance() {
        return planned_attendance;
    }

    public void setPlanned_attendance(Integer planned_attendance) {
        this.planned_attendance = planned_attendance;
    }

    public Integer getActual_attendance() {
        return actual_attendance;
    }

    public void setActual_attendance(Integer actual_attendance) {
        this.actual_attendance = actual_attendance;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getActual_total_cost() {
        return actual_total_cost;
    }

    public void setActual_total_cost(BigDecimal actual_total_cost) {
        this.actual_total_cost = actual_total_cost;
    }

    public BigDecimal getMeeting_expenses() {
        return meeting_expenses;
    }

    public void setMeeting_expenses(BigDecimal meeting_expenses) {
        this.meeting_expenses = meeting_expenses;
    }

    public BigDecimal getTransportation_expenses() {
        return transportation_expenses;
    }

    public void setTransportation_expenses(BigDecimal transportation_expenses) {
        this.transportation_expenses = transportation_expenses;
    }

    public BigDecimal getLabor_expenses() {
        return labor_expenses;
    }

    public void setLabor_expenses(BigDecimal labor_expenses) {
        this.labor_expenses = labor_expenses;
    }

    public Set<People> getOfficer() {
        return officer;
    }

    public void setOfficer(Set<People> officer) {
        this.officer = officer;
    }
}
