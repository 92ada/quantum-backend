package com.techncat.quantum.app.excel.model.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class ExpTravelRow {
    private Long id;

    private String travelerName;

    private Date start_date;
    private Date end_date;
    private String matter;
    private String location;
    private Integer number_of_people;
}
