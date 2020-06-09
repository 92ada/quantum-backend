package com.techncat.quantum.app.excel.model.daily;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.daily.Visit;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class VisitRow {
    @ExcelField(headName = "来访者姓名")
    private String name;
    @ExcelField(headName = "呈批是否已提交")
    private String approval_status;
    @ExcelField(headName = "备注")
    private String remark;
    @ExcelField(headName = "来访单位")
    private String visitor_institution;
    @ExcelField(headName = "职称")
    private String job_title;

    @ExcelField(headName = "我方对接人")
    private String receptionistName;
    @ExcelField(headName = "证件类型")
    private String identity_type;
    @ExcelField(headName = "证件号")
    private String identity_no;
    @ExcelField(headName = "手机号")
    private String phone_no;
    @ExcelField(headName = "邮箱")
    private String email;
    @ExcelField(headName = "住宿地点")
    private String accommodation;
    @ExcelField(headName = "是否已安排接送机")
    private String needs_pick_up;
    @ExcelField(headName = "使用经费")
    private String expenditure;
    @ExcelField(headName = "预算")
    private String budget;
    @ExcelField(headName = "来访时间")
    private String time;

    public static VisitRow render(Visit visit) {
        VisitRow row = new VisitRow();
        row.name = visit.getName();
        if (visit.getApproval_status() != null)
            row.approval_status = visit.getApproval_status().getValue();
        row.remark = visit.getRemark();
        row.visitor_institution = visit.getVisitor_institution();
        row.job_title = visit.getJob_title();
        if (visit.getReceptionist() != null)
            row.receptionistName = visit.getReceptionist().getName();
        if (visit.getIdentity_type() != null)
            row.identity_type = visit.getIdentity_type().getValue();
        row.identity_no = visit.getIdentity_no();
        row.phone_no = visit.getPhone_no();
        row.email = visit.getEmail();
        row.accommodation = visit.getAccommodation();
        row.needs_pick_up = FormatUtil.format(visit.getNeeds_pick_up());
        row.expenditure = FormatUtil.format(visit.getExpenditure());
        row.budget = FormatUtil.format(visit.getBudget());
        row.time = FormatUtil.formatDatetime(visit.getTime());
        return row;
    }

    public static Visit load(VisitRow row) {
        if (row.name == null || row.name.trim().length() == 0) return null;
        Visit p = new Visit();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());
        p.setName(row.name);
        p.setApproval_status(FormatUtil.formatEnum(Visit.Status.class, row.approval_status));
        p.setRemark(row.remark);
        p.setVisitor_institution(row.visitor_institution);
        p.setJob_title(row.job_title);
//        p.setReceptionist(null);
        p.setIdentity_type(FormatUtil.formatEnum(Visit.IdentityType.class, row.identity_type));
        p.setIdentity_no(row.identity_no);
        p.setPhone_no(row.phone_no);
        p.setEmail(row.email);
        p.setAccommodation(row.accommodation);
        p.setNeeds_pick_up(FormatUtil.toBoolean(row.needs_pick_up));
        p.setExpenditure(FormatUtil.toBigDecimal(row.expenditure));
        p.setBudget(FormatUtil.toBigDecimal(row.budget));
        p.setTime(FormatUtil.formatDatetime(row.time));
        return p;
    }
}
