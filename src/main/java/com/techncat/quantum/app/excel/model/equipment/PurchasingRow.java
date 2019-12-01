package com.techncat.quantum.app.excel.model.equipment;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.equipment.Purchasing;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurchasingRow {
//    private Long id;

    private String updateAt;
    private String createdAt;

    private String title;
    private BigDecimal budget;
    private Boolean is_imported;
    private String purchasing_method;
    private String argument_method;
    private String request_date;

    private String handlerName;
    private String piName;

    private Boolean is_finished;
    private String status;
    private String supplier_reply_delivery_time;
    private String bid_winning_supplier;
    private BigDecimal contract_amount;
    private BigDecimal paid_amount;
    private String contract_date;
    private String placement_site;
    private String funding_source;
    private String contract_no;
    private String payment_details;
    private String manufacturer;
    private String supplier_contact_person;
    private String supplier_contact_phone;
    private String supplier_contact_email;
    private String remark;

    public static PurchasingRow render(Purchasing purchasing) {
        PurchasingRow row = new PurchasingRow();
//        row.id = purchasing.getId();
        row.createdAt = FormatUtil.formatDateTime(purchasing.getCreatedAt());
        row.updateAt = FormatUtil.formatDateTime(purchasing.getUpdateAt());
        row.title = purchasing.getTitle();
        row.budget = purchasing.getBudget();
        row.is_imported = purchasing.getIs_imported();
        row.purchasing_method = purchasing.getPurchasing_method();
        row.argument_method = purchasing.getArgument_method();
        row.request_date = FormatUtil.formatDate(purchasing.getRequest_date());
        if (purchasing.getHandler() != null)
            row.handlerName = purchasing.getHandler().getName();
        if (purchasing.getPi() != null)
            row.piName = purchasing.getPi().getName();
        row.is_finished = purchasing.getIs_finished();
        row.status = purchasing.getStatus();
        row.supplier_reply_delivery_time = purchasing.getSupplier_reply_delivery_time();
        row.bid_winning_supplier = purchasing.getBid_winning_supplier();
        row.contract_amount = purchasing.getContract_amount();
        row.paid_amount = purchasing.getPaid_amount();
        row.contract_date = FormatUtil.formatDate(purchasing.getContract_date());
        row.placement_site = purchasing.getPlacement_site();
        row.funding_source = purchasing.getFunding_source();
        row.contract_no = purchasing.getContract_no();
        row.payment_details = purchasing.getPayment_details();
        row.manufacturer = purchasing.getManufacturer();
        row.supplier_contact_person = purchasing.getSupplier_contact_person();
        row.supplier_contact_phone = purchasing.getSupplier_contact_phone();
        row.supplier_contact_email = purchasing.getSupplier_contact_email();
        row.remark = purchasing.getRemark();
        return row;
    }

    public static Purchasing load(PurchasingRow row) {
        if (row.contract_no == null || row.contract_no.trim().length() == 0) return null;
        Purchasing p = new Purchasing();
        p.setId(null);
        p.setUpdateAt(FormatUtil.formatDate(row.updateAt));
        p.setCreatedAt(FormatUtil.formatDate(row.createdAt));
        p.setTitle(row.title);
        p.setBudget(row.budget);
        p.setIs_imported(row.is_imported);
        p.setIs_finished(row.is_finished);
        p.setPurchasing_method(row.purchasing_method);
        p.setArgument_method(row.argument_method);
        p.setRequest_date(FormatUtil.formatDate(row.request_date));
        p.setStatus(row.status);
        p.setSupplier_reply_delivery_time(row.supplier_reply_delivery_time);
        p.setBid_winning_supplier(row.bid_winning_supplier);
        p.setContract_amount(row.contract_amount);
        p.setPaid_amount(row.paid_amount);
        p.setContract_date(FormatUtil.formatDate(row.contract_date));
        p.setPlacement_site(row.placement_site);
        p.setFunding_source(row.funding_source);
        p.setContract_no(row.contract_no);
        p.setPayment_details(row.payment_details);
        p.setManufacturer(row.manufacturer);
        p.setSupplier_contact_phone(row.supplier_contact_phone);
        p.setSupplier_contact_person(row.supplier_contact_person);
        p.setSupplier_contact_email(row.supplier_contact_email);
        p.setRemark(row.remark);
        return p;
    }
}
