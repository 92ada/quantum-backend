package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.model.research.Project;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectFundVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private Date arrival_date;
    private BigDecimal amount;
    private String remark;
}
