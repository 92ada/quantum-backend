package com.techncat.quantum.app.excel.model.equipment;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.equipment.Stock;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StockRow {
    @ExcelField(headName = "类别")
    private String type;

    @ExcelField(headName = "库存编号")
    private String no;

    @ExcelField(headName = "名称")
    private String title;

    @ExcelField(headName = "型号")
    private String model;

    @ExcelField(headName = "价值")
    private String value;

    @ExcelField(headName = "净值")
    private String net_value;

    @ExcelField(headName = "领用单位")
    private String taker_institution;

    @ExcelField(headName = "领用人")
    private String takerName;

    @ExcelField(headName = "存放地")
    private String placement_site;

    @ExcelField(headName = "出厂号")
    private String factory_no;

    @ExcelField(headName = "现状")
    private String status;

    @ExcelField(headName = "已使用年限")
    private String used_years;

    @ExcelField(headName = "最低使用年限")
    private String min_usage_years;

    @ExcelField(headName = "入库日期")
    private String inbound_date;

    @ExcelField(headName = "单位管理员")
    private String adminName;

    @ExcelField(headName = "财务凭单号")
    private String document_no;

    @ExcelField(headName = "备注")
    private String remark;


    public static StockRow render(Stock stock) {
        StockRow row = new StockRow();
        row.type = stock.getType();
        row.no = stock.getNo();
        row.title = stock.getTitle();
        row.model = stock.getModel();
        row.value = FormatUtil.format(stock.getValue());
        row.net_value = FormatUtil.format(stock.getNet_value());
        row.taker_institution = stock.getTaker_institution();
        if (stock.getTaker() != null)
            row.takerName = stock.getTaker().getName();
        row.placement_site = stock.getPlacement_site();
        row.factory_no = stock.getFactory_no();
        row.status = stock.getStatus();
        row.used_years = FormatUtil.format(stock.getUsed_years());
        row.min_usage_years = FormatUtil.format(stock.getMin_usage_years());
        row.inbound_date = FormatUtil.formatDate(stock.getInbound_date());
        if (stock.getAdmin() != null)
            row.adminName = stock.getAdmin().getName();
        row.document_no = stock.getDocument_no();
        row.remark = stock.getRemark();
        return row;
    }

    public static Stock load(StockRow row) {
        if (row.no == null || row.no.trim().length() == 0) return null;
        Stock stock = new Stock();
        stock.setId(null);
        stock.setUpdateAt(new Date());
        stock.setCreatedAt(new Date());
        stock.setType(row.type);
        stock.setNo(row.no);
        stock.setTitle(row.title);
        stock.setModel(row.model);
        stock.setValue(FormatUtil.toBigDecimal(row.value));
        stock.setNet_value(FormatUtil.toBigDecimal(row.net_value));
        stock.setTaker_institution(row.taker_institution);
        stock.setPlacement_site(row.placement_site);
        stock.setFactory_no(row.factory_no);
        stock.setStatus(row.status);
        stock.setUsed_years(FormatUtil.toInteger(row.used_years));
        stock.setMin_usage_years(FormatUtil.toInteger(row.min_usage_years));
        stock.setInbound_date(FormatUtil.formatDate(row.inbound_date));
        stock.setDocument_no(row.document_no);
        stock.setRemark(row.remark);
        stock.setTaker(null);
        stock.setAdmin(null);
        return stock;
    }
}
