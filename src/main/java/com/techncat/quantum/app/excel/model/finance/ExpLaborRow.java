package com.techncat.quantum.app.excel.model.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpLaborRow {
    private Long id;

    private String category;
    private String matter;
    private BigDecimal standard;
    private Integer days;

    private String handlerName;
}
