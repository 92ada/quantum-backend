package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpLaborVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String category;
    private String matter;
    private BigDecimal standard;
    private Integer days;

    @ValueType(value = "people", option_url = "/api/people/options")
    private Object handlerJson;
}
