package com.techncat.quantum.app.excel.model.equipment;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurchasingRow {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private BigDecimal budget;
    private Boolean is_imported;
    private String purchasing_method;
    private String argument_method;
    private Date request_date;

    private String handlerName;
    private String piName;

    private Boolean is_finished;
    private String status;
    private String supplier_reply_delivery_time;
    private String bid_winning_supplier;
    private BigDecimal contract_amount;
    private BigDecimal paid_amount;
    private Date contract_date;
    private String placement_site;
    private String funding_source;
    private String contract_no;
    private String payment_details;
    private String manufacturer;
    private String supplier_contact_person;
    private String supplier_contact_phone;
    private String supplier_contact_email;
    private String remark;
}