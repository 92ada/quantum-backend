package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;

import java.util.Date;

public class ExpInternationalVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private Date start_date;
    private Date end_date;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String peopleJson;

    private String matter;
    private String location;
    private Integer number_of_people;

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

    public String getPeopleJson() {
        return peopleJson;
    }

    public void setPeopleJson(String peopleJson) {
        this.peopleJson = peopleJson;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(Integer number_of_people) {
        this.number_of_people = number_of_people;
    }
}
