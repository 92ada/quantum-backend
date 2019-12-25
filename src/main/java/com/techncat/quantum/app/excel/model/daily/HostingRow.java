package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class HostingRow {
    @ExcelField(headName = "时间")
    private String time;
    @ExcelField(headName = "会议名称")
    private String title;
    @ExcelField(headName = "地点")
    private String site;
    @ExcelField(headName = "是否报销")
    private String is_reimbursement;
}
