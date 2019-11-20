package com.techncat.quantum.app.excel.model.equipment;

import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.equipment.Stock;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StockRow {
//    private Long id;

    private String updateAt;
    private String createdAt;

    private String type;
    private String no;
    private String title;
    private String model;
    private BigDecimal value;
    private BigDecimal net_value;
    private String taker_institution;

    private String takerName;

    private String placement_site;
    private String factory_no;
    private String status;
    private Integer used_years;
    private Integer min_usage_years;
    private String inbound_date;

    private String adminName;

    private String document_no;
    private String remark;

    public static StockRow render(Stock stock) {
        StockRow row = new StockRow();
//        row.id = stock.getId();
        row.updateAt = FormatUtil.formatDate(stock.getUpdateAt());
        row.createdAt = FormatUtil.formatDate(stock.getCreatedAt());
        row.type = stock.getType();
        row.no = stock.getNo();
        row.title = stock.getTitle();
        row.model = stock.getModel();
        row.value = stock.getValue();
        row.net_value = stock.getNet_value();
        row.taker_institution = stock.getTaker_institution();
        if (stock.getTaker() != null)
            row.takerName = stock.getTaker().getName();
        row.placement_site = stock.getPlacement_site();
        row.factory_no = stock.getFactory_no();
        row.status = stock.getStatus();
        row.used_years = stock.getUsed_years();
        row.min_usage_years = stock.getMin_usage_years();
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
        stock.setUpdateAt(FormatUtil.formatDate(row.updateAt));
        stock.setCreatedAt(FormatUtil.formatDate(row.createdAt));
        stock.setType(row.type);
        stock.setNo(row.no);
        stock.setTitle(row.title);
        stock.setModel(row.model);
        stock.setValue(row.value);
        stock.setNet_value(row.net_value);
        stock.setTaker_institution(row.taker_institution);
        stock.setPlacement_site(row.placement_site);
        stock.setFactory_no(row.factory_no);
        stock.setStatus(row.status);
        stock.setUsed_years(row.used_years);
        stock.setMin_usage_years(row.min_usage_years);
        stock.setInbound_date(FormatUtil.formatDate(row.inbound_date));
        stock.setDocument_no(row.document_no);
        stock.setRemark(row.remark);
        stock.setTaker(null);
        stock.setAdmin(null);
        return stock;
    }
}
