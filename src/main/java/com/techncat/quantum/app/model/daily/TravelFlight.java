package com.techncat.quantum.app.model.daily;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "travel_flights")
public class TravelFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "travel_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Travel travel;

    private Date departure_time;
    private Date arrival_time;
    private String departure_site;
    private String arrival_site;
    private String flight_no;
    private String price;

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

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_site() {
        return departure_site;
    }

    public void setDeparture_site(String departure_site) {
        this.departure_site = departure_site;
    }

    public String getArrival_site() {
        return arrival_site;
    }

    public void setArrival_site(String arrival_site) {
        this.arrival_site = arrival_site;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
