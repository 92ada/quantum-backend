package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpLabor;
import com.techncat.quantum.app.model.people.People;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class ExpLaborVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String category;
    private String matter;
    private BigDecimal standard;
    private Integer days;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;
}
