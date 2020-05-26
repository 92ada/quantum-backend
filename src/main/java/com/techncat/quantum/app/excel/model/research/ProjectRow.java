package com.techncat.quantum.app.excel.model.research;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.service.utils.JsonLoader;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
public class ProjectRow {
    @ExcelField(headName = "项目名称")
    private String title;
    @ExcelField(headName = "项目类型")
    private String type;
    @ExcelField(headName = "项目类别")
    private String category;
    @ExcelField(headName = "项目负责人工号")
    private String leaderSid;
    @ExcelField(headName = "项目负责人姓名")
    private String leaderName;
    @ExcelField(headName = "起始日期")
    private String start_date;
    @ExcelField(headName = "终止日期")
    private String end_date;
    @ExcelField(headName = "承担方式")
    private String way_of_taking;
    @ExcelField(headName = "获批经费（万元）")
    private String approved_funds;
    @ExcelField(headName = "经费号")
    private String expenditureNo;

    public static ProjectRow render(Project project) {
        ProjectRow row = new ProjectRow();
        if (project.getLeader() != null) {
            row.leaderName = project.getLeader().getName();
            row.leaderSid = project.getLeader().getSid();
        }

        row.title = project.getTitle();
        row.type = project.getType();

        if (project.getCategory() != null)
            row.category = project.getCategory().toString();

        row.start_date = FormatUtil.formatDate(project.getStart_date());
        row.end_date = FormatUtil.formatDate(project.getEnd_date());

        if (project.getWay_of_taking() != null)
            row.way_of_taking = project.getWay_of_taking().toString();

        row.approved_funds = FormatUtil.format(project.getApproved_funds());
        row.expenditureNo = project.getExpenditureNo();
        return row;
    }

    public static Project load(ProjectRow row) {
        if (row.title == null || row.title.trim().length() == 0) return null;
        Project p = new Project();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setLeader(RowUtil.loadPeopleFromSid(row.leaderSid));
        p.setLeaderJson(RowUtil.toJson(p.getLeader()));
        p.setTitle(row.title);
        p.setType(row.type);
        p.setCategory(FormatUtil.formatEnum(Project.Category.class, row.category));
        p.setStart_date(FormatUtil.formatDate(row.start_date));
        p.setEnd_date(FormatUtil.formatDate(row.end_date));
        p.setWay_of_taking(FormatUtil.formatEnum(Project.WayOfTaking.class, row.way_of_taking));
        p.setApproved_funds(FormatUtil.toBigDecimal(row.approved_funds));
        p.setExpenditureNo(row.expenditureNo);
        return p;
    }
}
