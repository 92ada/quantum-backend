package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.daily.Travel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TravelRow {
    @ExcelField(headName = "出行人")
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
}
