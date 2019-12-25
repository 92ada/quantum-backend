package com.techncat.quantum.app.excel.model.finance;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.finance.Exp;
import lombok.Data;

@Data
public class ExpRow {
    @ExcelField(headName = "经费号")
    private String expenditure_no;

    @ExcelField(headName = "摘要")
    private String summary;

    @ExcelField(headName = "费用类别")
    private String type;

    @ExcelField(headName = "日期")
    private String date;

    @ExcelField(headName = "预约单号")
    private String reservation_no;

    @ExcelField(headName = "金额（实际费用）")
    private String amount;

    @ExcelField(headName = "凭证月份")
    private String document_month;

    @ExcelField(headName = "凭证编号")
    private String document_no;

    @ExcelField(headName = "备注")
    private String remark;

    @ExcelField(headName = "所属课题组")
    private String labName;

    public static ExpRow render(Exp exp) {
        ExpRow row = new ExpRow();
        if (exp.getType() != null)
            row.type = exp.getType().name();
        row.expenditure_no = exp.getExpenditureNo();
        row.summary = exp.getSummary();
        row.date = FormatUtil.formatDate(exp.getDate());
        row.reservation_no = exp.getReservation_no();
        row.amount = FormatUtil.format(exp.getAmount());
        row.document_month = FormatUtil.format(exp.getDocument_month());
        row.document_no = exp.getDocument_no();
        row.remark = exp.getRemark();
        if (exp.getLab() != null)
            row.labName = exp.getLab().getName();
        return row;
    }

    public static Exp load(ExpRow row) {
        if (row.reservation_no == null || row.reservation_no.trim().length() == 0) return null;
        Exp exp = new Exp();
        exp.setId(null);
        exp.setType(FormatUtil.formatEnum(Exp.Type.class, row.type));
        exp.setDate(FormatUtil.formatDate(row.date));
        exp.setReservation_no(row.reservation_no);
        exp.setExpenditureNo(row.expenditure_no);
        exp.setAmount(FormatUtil.toBigDecimal(row.amount));
        exp.setDocument_month(FormatUtil.toInteger(row.document_month));
        exp.setDocument_no(row.document_no);
        exp.setRemark(row.remark);
        exp.setSummary(row.summary);
        return exp;
    }
}
