package com.techncat.quantum.app.excel.model.research;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.service.utils.JsonLoader;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.stream.Collectors;

@Data
public class PatentRow {
    @ExcelField(headName = "申请人姓名")
    private String applicantName;
    @ExcelField(headName = "专利名称")
    private String title;
    @ExcelField(headName = "专利类型")
    private String type;
    @ExcelField(headName = "专利状态")
    private String status;
    @ExcelField(headName = "申请日期")
    private String apply_date;
    @ExcelField(headName = "授权日期")
    private String approve_date;
    @ExcelField(headName = "申请号")
    private String apply_no;
    @ExcelField(headName = "专利号")
    private String patent_no;
    @ExcelField(headName = "是否PCT")
    private String is_pct;
    @ExcelField(headName = "发明人排序")
    private String inventor_rank;

    public static PatentRow render(Patent patent) {
        PatentRow row = new PatentRow();
        if (patent.getApplicant() != null && patent.getApplicant().size() != 0) {
            row.applicantName = patent.getApplicant().stream().map(people -> people.getName() + " (" + people.getId() + ")").collect(Collectors.joining(","));
        }

        row.title = patent.getTitle();
        if (patent.getType() != null)
            row.type = patent.getType().toString();
        if (patent.getStatus() != null)
            row.status = patent.getStatus().toString();

        row.apply_date = FormatUtil.formatDate(patent.getApply_date());
        row.approve_date = FormatUtil.formatDate(patent.getApprove_date());
        row.apply_no = patent.getApply_no();
        row.patent_no = patent.getPatent_no();
        row.is_pct = FormatUtil.format(patent.getIs_pct());
        row.inventor_rank = FormatUtil.format(patent.getInventor_rank());
        return row;
    }

    public static Patent load(PatentRow row) {
        if (row.title == null || row.title.trim().length() == 0) return null;
        Patent p = new Patent();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setApplicantJson(RowUtil.loadJson(row.applicantName));
        p.setApplicant(RowUtil.parsePeopleList(row.applicantName));
        p.setTitle(row.title);
        p.setType(FormatUtil.formatEnum(Patent.Type.class, row.type));
        p.setStatus(FormatUtil.formatEnum(Patent.Status.class, row.status));
        p.setApply_date(FormatUtil.formatDate(row.apply_date));
        p.setApprove_date(FormatUtil.formatDate(row.approve_date));
        p.setApply_no(row.apply_no);
        p.setPatent_no(row.patent_no);
        p.setIs_pct(FormatUtil.toBoolean(row.is_pct));
        p.setInventor_rank(FormatUtil.toInteger(row.inventor_rank));
        return p;
    }
}
