package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import lombok.Data;

import java.util.Date;

@Data
public class FlightRow {
    @ExcelField(headName = "乘机时间")
    private String departure_time;
    @ExcelField(headName = "到达时间")
    private String arrival_time;
    @ExcelField(headName = "出发地")
    private String departure_site;
    @ExcelField(headName = "到达地")
    private String arrival_site;
    @ExcelField(headName = "航班号")
    private String flight_no;
    @ExcelField(headName = "价格")
    private String price;
}
