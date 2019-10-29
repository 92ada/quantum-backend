package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.model.daily.Travel;

import java.util.Date;

public class TravelFlightVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private Travel travel; // TODO

    private Date departure_time;
    private Date arrival_time;
    private String departure_site;
    private String arrival_site;
    private String flight_no;
    private String price;
}
