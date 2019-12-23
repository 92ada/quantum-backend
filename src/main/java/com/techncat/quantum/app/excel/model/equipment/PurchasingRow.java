package com.techncat.quantum.app.excel.model.equipment;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.equipment.Purchasing;
import lombok.Data;

import java.util.Date;

@Data
public class PurchasingRow {
    @ExcelField(headName = "项目名")
    private String title;

    @ExcelField(headName = "预算金额")
    private String budget;

    @ExcelField(headName = "是否进口")
    private String is_imported;

    @ExcelField(headName = "采购方式")
    private String purchasing_method;

    @ExcelField(headName = "论证方式")
    private String argument_method;

    @ExcelField(headName = "提交采购申请日期")
    private String request_date;

    @ExcelField(headName = "经办人")
    private String handlerName;

    @ExcelField(headName = "所属PI")
    private String piName;

    @ExcelField(headName = "已完成")
    private String is_finished;

    @ExcelField(headName = "目前情况")
    private String status;

    @ExcelField(headName = "供应商回复交货时间")
    private String supplier_reply_delivery_time;

    @ExcelField(headName = "中标供应商")
    private String bid_winning_supplier;

    @ExcelField(headName = "合同金额")
    private String contract_amount;

    @ExcelField(headName = "已支付金额")
    private String paid_amount;

    @ExcelField(headName = "合同签订日期")
    private String contract_date;

    @ExcelField(headName = "放置地点")
    private String placement_site;

    @ExcelField(headName = "经费归属")
    private String funding_source;

    @ExcelField(headName = "采购合同号")
    private String contract_no;

    @ExcelField(headName = "付款详情")
    private String payment_details;

    @ExcelField(headName = "厂家")
    private String manufacturer;

    @ExcelField(headName = "厂家／供应商联系人")
    private String supplier_contact_person;

    @ExcelField(headName = "厂家／供应商联系电话")
    private String supplier_contact_phone;

    @ExcelField(headName = "厂家邮箱")
    private String supplier_contact_email;

    @ExcelField(headName = "备注")
    private String remark;


    public static PurchasingRow render(Purchasing purchasing) {
        PurchasingRow row = new PurchasingRow();
        row.title = purchasing.getTitle();
        row.budget = FormatUtil.format(purchasing.getBudget());
        row.is_imported = FormatUtil.format(purchasing.getIs_imported());
        row.purchasing_method = purchasing.getPurchasing_method();
        row.argument_method = purchasing.getArgument_method();
        row.request_date = FormatUtil.formatDate(purchasing.getRequest_date());
        if (purchasing.getHandler() != null)
            row.handlerName = purchasing.getHandler().getName();
        if (purchasing.getPi() != null)
            row.piName = purchasing.getPi().getName();
        row.is_finished = FormatUtil.format(purchasing.getIs_finished());
        row.status = purchasing.getStatus();
        row.supplier_reply_delivery_time = purchasing.getSupplier_reply_delivery_time();
        row.bid_winning_supplier = purchasing.getBid_winning_supplier();
        row.contract_amount = FormatUtil.format(purchasing.getContract_amount());
        row.paid_amount = FormatUtil.format(purchasing.getPaid_amount());
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
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());
        p.setTitle(row.title);
        p.setBudget(FormatUtil.toBigDecimal(row.budget));
        p.setIs_imported(FormatUtil.toBoolean(row.is_imported));
        p.setIs_finished(FormatUtil.toBoolean(row.is_finished));
        p.setPurchasing_method(row.purchasing_method);
        p.setArgument_method(row.argument_method);
        p.setRequest_date(FormatUtil.formatDate(row.request_date));
        p.setStatus(row.status);
        p.setSupplier_reply_delivery_time(row.supplier_reply_delivery_time);
        p.setBid_winning_supplier(row.bid_winning_supplier);
        p.setContract_amount(FormatUtil.toBigDecimal(row.contract_amount));
        p.setPaid_amount(FormatUtil.toBigDecimal(row.paid_amount));
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
