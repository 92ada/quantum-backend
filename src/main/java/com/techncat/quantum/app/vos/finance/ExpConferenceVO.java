package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;

import java.math.BigDecimal;
import java.util.Date;

public class ExpConferenceVO extends ExpVO {
    private Date start_date;
    private Date end_date;
    private String place_of_participation;
    private Integer planned_attendance;
    private Integer actual_attendance;
    private BigDecimal budget;
    private BigDecimal actual_total_cost;
    private BigDecimal meeting_expenses;
    private BigDecimal transportation_expenses;
    private BigDecimal labor_expenses;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String officersJson;

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

    public String getOfficersJson() {
        return officersJson;
    }

    public void setOfficersJson(String officersJson) {
        this.officersJson = officersJson;
    }
}
