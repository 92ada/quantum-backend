package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.daily.Travel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TravelRow {
    @ExcelField(headName = "出行人工号")
    private String travelerSid;
    @ExcelField(headName = "出行人姓名")
    private String travelerName;

    @ExcelField(headName = "类型")
    private String type;
    @ExcelField(headName = "预算（元）")
    private String budget;
    @ExcelField(headName = "起始日期")
    private String startDate;
    @ExcelField(headName = "结束日期")
    private String endDate;

    @ExcelField(headName = "证件类型")
    private String identity_type;
    @ExcelField(headName = "证件号")
    private String identity_no;

    public static TravelRow render(Travel travel) {
        TravelRow row = new TravelRow();
        if (travel.getTraveler() != null) {
            row.travelerSid = travel.getTraveler().getSid();
            row.travelerName = travel.getTraveler().getName();
        }
        if (travel.getType() != null)
            row.type = travel.getType().getValue();

        row.budget = FormatUtil.format(travel.getBudget());
        row.startDate = FormatUtil.formatDate(travel.getStartDate());
        row.endDate = FormatUtil.formatDate(travel.getEndDate());

        if (travel.getIdentity_type() != null)
            row.identity_type = travel.getIdentity_type().getValue();
        row.identity_no = travel.getIdentity_no();

        return row;
    }

    public static Travel load(TravelRow row) {
        if (row.travelerSid == null || row.travelerSid.trim().length() == 0) return null;
        Travel p = new Travel();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setType(FormatUtil.formatEnum(Travel.Type.class, row.type));
        p.setBudget(FormatUtil.toBigDecimal(row.budget));
        p.setStartDate(FormatUtil.formatDate(row.startDate));
        p.setEndDate(FormatUtil.formatDate(row.endDate));

        p.setIdentity_type(FormatUtil.formatEnum(Travel.IdentityType.class, row.identity_type));
        p.setIdentity_no(row.identity_no);
        return p;
    }
}
