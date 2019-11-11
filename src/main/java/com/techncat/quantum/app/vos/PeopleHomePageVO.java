package com.techncat.quantum.app.vos;

import lombok.Data;

import java.util.Date;

@Deprecated
@Data
public class PeopleHomePageVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String type;
    private String status;
    private String name;
    private Date birth_date;
    private String phone;
    private String email;
    private String political_status;
    private String description;
    private Date entry_date;
    private Date departure_date;
    private String gender;
}
