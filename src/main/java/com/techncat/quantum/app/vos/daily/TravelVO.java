package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.daily.Travel;

import java.math.BigDecimal;
import java.util.Date;

public class TravelVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String travelerJson;
    @ValueType("enumerated")
    private Travel.Type type;
    private BigDecimal budget;
    private Date start_date;
    private Date end_date;

    @ValueType("enumerated")
    private Travel.IdentityType identity_type;
    private String identity_no;
}
