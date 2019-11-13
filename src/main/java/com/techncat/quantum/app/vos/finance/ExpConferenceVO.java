package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpConferenceVO extends ExpVO {
    private Date start_date;
    private Date end_date;
    private String place_of_participation;
    private Integer planned_attendance;
    private Integer actual_attendance;
    private BigDecimal budget;
    private BigDecimal actual_total_cost;
    private BigDecimal meeting_expenses;
    private BigDecimal transportation_expenses;
    private BigDecimal labor_expenses;

    @ValueType(value = "people", option_url = "/api/people/options")
    private Object officersJson;
}
