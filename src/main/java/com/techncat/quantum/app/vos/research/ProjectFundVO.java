package com.techncat.quantum.app.vos.research;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProjectFundVO {
    private Long id;

    private Date arrival_date;
    private BigDecimal amount;
    private String remark;
}
