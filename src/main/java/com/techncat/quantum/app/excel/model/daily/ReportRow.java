package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.daily.Report;
import lombok.Data;

import java.util.Date;

@Data
public class ReportRow {
    @ExcelField(headName = "邀请人工号")
    private String inviterSid;
    @ExcelField(headName = "邀请人姓名")
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

    public static ReportRow render(Report report) {
        ReportRow row = new ReportRow();
        if (report.getInviter() != null) {
            row.inviterSid = report.getInviter().getSid();
            row.inviterName = report.getInviter().getName();
        }

        row.time = FormatUtil.formatDatetime(report.getTime());
        row.title = report.getTitle();
        row.inviteeName = report.getInvitee_name();
        row.people_count = FormatUtil.format(report.getPeople_count());
        row.location = report.getLocation();
        return row;
    }

    public static Report load(ReportRow row) {
        if (row.inviterSid == null || row.inviterSid.trim().length() == 0) return null;
        Report p = new Report();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setTime(FormatUtil.formatDatetime(row.time));
        p.setTitle(row.title);
        p.setInvitee_name(row.inviteeName);
        p.setPeople_count(FormatUtil.toInteger(row.people_count));
        p.setLocation(row.location);

        return p;
    }
}
