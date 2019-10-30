package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.finance.ExpEquipment;

import java.math.BigDecimal;
import java.util.Date;

public class ExpEquipmentVO extends ExpVO {
    @ValueType("enumerated")
    private ExpEquipment.Type purchase_type;
    private Integer payment_status;
    private String inbound_no;
    private BigDecimal warranty_amount;
    private Date warranty_date;

    public ExpEquipment.Type getPurchase_type() {
        return purchase_type;
    }

    public void setPurchase_type(ExpEquipment.Type purchase_type) {
        this.purchase_type = purchase_type;
    }

    public Integer getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(Integer payment_status) {
        this.payment_status = payment_status;
    }

    public String getInbound_no() {
        return inbound_no;
    }

    public void setInbound_no(String inbound_no) {
        this.inbound_no = inbound_no;
    }

    public BigDecimal getWarranty_amount() {
        return warranty_amount;
    }

    public void setWarranty_amount(BigDecimal warranty_amount) {
        this.warranty_amount = warranty_amount;
    }

    public Date getWarranty_date() {
        return warranty_date;
    }

    public void setWarranty_date(Date warranty_date) {
        this.warranty_date = warranty_date;
    }
}
