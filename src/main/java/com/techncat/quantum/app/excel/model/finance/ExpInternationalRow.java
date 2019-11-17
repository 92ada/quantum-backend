package com.techncat.quantum.app.excel.model.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class ExpInternationalRow {
    private Long id;

    private Date start_date;
    private Date end_date;

    private Object peopleName;

    private String matter;
    private String location;
    private Integer number_of_people;
}
