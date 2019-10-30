package com.techncat.quantum.app.model.finance;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exp_travels")
public class ExpTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    @ManyToOne
    @JoinColumn(name = "travel_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People traveler;
    @Column(columnDefinition="text")
    private String travelerJson;

    private Date start_date;
    private Date end_date;
    private String matter;
    private String location;
    private Integer number_of_people;

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

    public People getTraveler() {
        return traveler;
    }

    public void setTraveler(People traveler) {
        this.traveler = traveler;
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

    public String getTravelerJson() {
        return travelerJson;
    }

    public void setTravelerJson(String travelerJson) {
        this.travelerJson = travelerJson;
    }
}
