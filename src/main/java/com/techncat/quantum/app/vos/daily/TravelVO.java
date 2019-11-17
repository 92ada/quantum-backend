package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.daily.Travel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TravelVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "people", option_url = "/api/people/options")
    private Object travelerJson;
    @ValueType("enumerated")
    private Travel.Type type;
    private BigDecimal budget;
    private Date startDate;
    private Date endDate;

    @ValueType("enumerated")
    private Travel.identity_type identity_type;
    private String identity_no;
}
