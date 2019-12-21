package com.techncat.quantum.app.excel.model.finance;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.finance.SocialFund;
import lombok.Data;

@Data
public class SocialFundRow {
    @ExcelField(headName = "工号")
    private String personSid;
    @ExcelField(headName = "姓名")
    private String personName;

    @ExcelField(headName = "个人公积金账号")
    private String fund_account_no;
    @ExcelField(headName = "经费来源")
    private String fund_source;
    @ExcelField(headName = "备注")
    private String remark;

    @ExcelField(headName = "个人缴费")
    private String personal_payment;
    @ExcelField(headName = "学校缴费")
    private String institutional_payment;
    @ExcelField(headName = "缴存基数")
    private String base_amount;
    @ExcelField(headName = "单位缴存比例")
    private String ratio_of_institutional_payment;
    @ExcelField(headName = "缴存额")
    private String amount;
    @ExcelField(headName = "缴存日期")
    private String date;

    public static SocialFundRow render(SocialFund fund) {
        SocialFundRow row = new SocialFundRow();
        if (fund.getPeople() != null) {
            row.personSid = fund.getPeople().getSid();
            row.personName = fund.getPeople().getName();
        }
        row.fund_account_no = fund.getFund_account_no();
        row.fund_source = fund.getFund_source();
        row.remark = fund.getRemark();

        row.personal_payment = FormatUtil.format(fund.getPersonal_payment());
        row.institutional_payment = FormatUtil.format(fund.getInstitutional_payment());
        row.base_amount = FormatUtil.format(fund.getBase_amount());
        row.ratio_of_institutional_payment = FormatUtil.format(fund.getRatio_of_institutional_payment());
        row.amount = FormatUtil.format(fund.getAmount());
        row.date = FormatUtil.formatDate(fund.getDate());
        return row;
    }
}
