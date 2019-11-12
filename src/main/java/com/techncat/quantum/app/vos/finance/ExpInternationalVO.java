package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
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
}
