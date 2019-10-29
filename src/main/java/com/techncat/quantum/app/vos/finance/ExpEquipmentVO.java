package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpEquipment;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class ExpEquipmentVO extends ExpVO {
    @ValueType("enumerated")
    private ExpEquipment.Type purchase_type;
    private Integer payment_status;
    private String inbound_no;
    private BigDecimal warranty_amount;
    private Date warranty_date;

    public ExpEquipmentVO(Exp exp, ExpEquipment expEquipment) {
        super(exp);
        copyProperties(expEquipment);
    }

    private void copyProperties(ExpEquipment expEquipment) {
        if (null == expEquipment) return;
        Long id = this.getId();
        Date createdAt = this.getCreatedAt();
        Date updatedAt = this.getUpdateAt();
        BeanUtils.copyProperties(expEquipment, this);
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setUpdateAt(updatedAt);
    }
}
