package com.techncat.quantum.app.vos.equipment;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StockVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String type;
    private String no;
    private String title;
    private String model;
    private BigDecimal value;
    private BigDecimal net_value;
    private String taker_institution;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String takerJson;

    private String placement_site;
    private String factory_no;
    private String status;
    private Integer used_years;
    private Integer min_usage_years;
    private Date inbound_date;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String adminJson;

    private String document_no;
    private String remark;
}
