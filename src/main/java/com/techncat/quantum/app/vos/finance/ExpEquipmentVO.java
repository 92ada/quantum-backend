package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
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
}
