package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.people.People;

import java.util.Date;

public class ExpTravelVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String travelerJson;

    private Date start_date;
    private Date end_date;
    private String matter;
    private String location;
    private Integer number_of_people;
}
