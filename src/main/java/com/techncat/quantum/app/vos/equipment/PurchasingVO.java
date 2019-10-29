package com.techncat.quantum.app.vos.equipment;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Boolean getIs_imported() {
        return is_imported;
    }

    public void setIs_imported(Boolean is_imported) {
        this.is_imported = is_imported;
    }

    public String getPurchasing_method() {
        return purchasing_method;
    }

    public void setPurchasing_method(String purchasing_method) {
        this.purchasing_method = purchasing_method;
    }

    public String getArgument_method() {
        return argument_method;
    }

    public void setArgument_method(String argument_method) {
        this.argument_method = argument_method;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public String getHandlerJson() {
        return handlerJson;
    }

    public void setHandlerJson(String handlerJson) {
        this.handlerJson = handlerJson;
    }

    public String getPiJson() {
        return piJson;
    }

    public void setPiJson(String piJson) {
        this.piJson = piJson;
    }

    public Boolean getIs_finished() {
        return is_finished;
    }

    public void setIs_finished(Boolean is_finished) {
        this.is_finished = is_finished;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupplier_reply_delivery_time() {
        return supplier_reply_delivery_time;
    }

    public void setSupplier_reply_delivery_time(String supplier_reply_delivery_time) {
        this.supplier_reply_delivery_time = supplier_reply_delivery_time;
    }

    public String getBid_winning_supplier() {
        return bid_winning_supplier;
    }

    public void setBid_winning_supplier(String bid_winning_supplier) {
        this.bid_winning_supplier = bid_winning_supplier;
    }

    public BigDecimal getContract_amount() {
        return contract_amount;
    }

    public void setContract_amount(BigDecimal contract_amount) {
        this.contract_amount = contract_amount;
    }

    public BigDecimal getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(BigDecimal paid_amount) {
        this.paid_amount = paid_amount;
    }

    public Date getContract_date() {
        return contract_date;
    }

    public void setContract_date(Date contract_date) {
        this.contract_date = contract_date;
    }

    public String getPlacement_site() {
        return placement_site;
    }

    public void setPlacement_site(String placement_site) {
        this.placement_site = placement_site;
    }

    public String getFunding_source() {
        return funding_source;
    }

    public void setFunding_source(String funding_source) {
        this.funding_source = funding_source;
    }

    public String getContract_no() {
        return contract_no;
    }

    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    public String getPayment_details() {
        return payment_details;
    }

    public void setPayment_details(String payment_details) {
        this.payment_details = payment_details;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSupplier_contact_person() {
        return supplier_contact_person;
    }

    public void setSupplier_contact_person(String supplier_contact_person) {
        this.supplier_contact_person = supplier_contact_person;
    }

    public String getSupplier_contact_phone() {
        return supplier_contact_phone;
    }

    public void setSupplier_contact_phone(String supplier_contact_phone) {
        this.supplier_contact_phone = supplier_contact_phone;
    }

    public String getSupplier_contact_email() {
        return supplier_contact_email;
    }

    public void setSupplier_contact_email(String supplier_contact_email) {
        this.supplier_contact_email = supplier_contact_email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
