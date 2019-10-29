package com.techncat.quantum.app.vos.equipment;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;

import java.math.BigDecimal;
import java.util.Date;

public class PurchasingVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private BigDecimal budget;
    private Boolean is_imported;
    private String purchasing_method;
    private String argument_method;
    private Date request_date;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;
    @ValueType(value = "object", option_url = "/api/people/options")
    private String piJson;

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
