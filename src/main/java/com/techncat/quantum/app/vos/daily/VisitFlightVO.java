package com.techncat.quantum.app.vos.daily;

import lombok.Data;

import java.util.Date;

@Data
public class VisitFlightVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private Date departure_time;
    private Date arrival_time;
    private String departure_site;
    private String arrival_site;
    private String flight_no;
    private String price;
}
