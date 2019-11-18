package com.techncat.quantum.app.excel.model.finance;

import com.techncat.quantum.app.common.voenhance.annotation.Editable;
import com.techncat.quantum.app.model.finance.Exp;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpRow {
    private Long id;

    //    @ValueType(value = "lab", option_url = "/api/labs/options")
//    private Lab lab;
    private String labName;

    @Editable(false)
    private Exp.Type type;
    private Date date;
    private String reservation_no;
    private BigDecimal amount;
    private Integer document_month;
    private String document_no;
    private String remark;

    public static ExpRow render(Exp exp) {
        ExpRow row = new ExpRow();
        row.id = exp.getId();
        row.type = exp.getType();
        row.date = exp.getDate();
        row.reservation_no = exp.getReservation_no();
        row.amount = exp.getAmount();
        row.document_month = exp.getDocument_month();
        row.document_no = exp.getDocument_no();
        row.remark = exp.getRemark();
        if (exp.getLab() != null)
            row.labName = exp.getLab().getName();
        return row;
    }

    public static Exp load(ExpRow row) {
        Exp exp = new Exp();
        exp.setId(row.id);
//        exp.setLab(null);
        exp.setType(row.type);
        exp.setDate(row.date);
        exp.setReservation_no(row.reservation_no);
        exp.setAmount(row.amount);
        exp.setDocument_month(row.document_month);
        exp.setDocument_no(row.document_no);
        exp.setRemark(row.remark);
        return exp;
    }
}
