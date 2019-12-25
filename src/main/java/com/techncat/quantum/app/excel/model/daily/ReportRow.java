package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class ReportRow {
    @ExcelField(headName = "邀请人")
    private String inviterName;

    @ExcelField(headName = "时间")
    private String time;
    @ExcelField(headName = "标题")
    private String title;
    @ExcelField(headName = "嘉宾姓名")
    private String inviteeName;
    @ExcelField(headName = "人数")
    private String people_count;
    @ExcelField(headName = "地点")
    private String location;
}
