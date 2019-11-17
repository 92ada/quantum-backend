package com.techncat.quantum.app.excel.model.equipment;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StockRow {
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

    private String takerName;

    private String placement_site;
    private String factory_no;
    private String status;
    private Integer used_years;
    private Integer min_usage_years;
    private Date inbound_date;

    private Object adminName;

    private String document_no;
    private String remark;
}
