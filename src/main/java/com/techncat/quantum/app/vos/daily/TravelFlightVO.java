package com.techncat.quantum.app.vos.daily;

import lombok.Data;

import java.util.Date;

@Data
public class TravelFlightVO {
    private Long id;

    private Date departure_time;
    private Date arrival_time;
    private String departure_site;
    private String arrival_site;
    private String flight_no;
    private String price;
    private String remark;
}
