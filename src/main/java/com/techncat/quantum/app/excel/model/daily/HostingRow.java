package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.daily.Hosting;
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

    public static HostingRow render(Hosting hosting) {
        HostingRow row = new HostingRow();

        row.time = FormatUtil.formatDatetime(hosting.getTime());
        row.title = hosting.getTitle();
        row.site = hosting.getSite();
        row.is_reimbursement = FormatUtil.format(hosting.getIs_reimbursement());
        return row;
    }

    public static Hosting load(HostingRow row) {
        if (row.title == null || row.title.trim().length() == 0) return null;
        Hosting p = new Hosting();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setTime(FormatUtil.formatDatetime(row.time));
        p.setTitle(row.title);
        p.setSite(row.site);
        p.setIs_reimbursement(FormatUtil.toBoolean(row.is_reimbursement));

        return p;
    }
}
