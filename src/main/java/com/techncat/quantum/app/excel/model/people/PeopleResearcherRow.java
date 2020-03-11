package com.techncat.quantum.app.excel.model.people;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.PeopleResearcher;
import lombok.Data;

@Data
public class PeopleResearcherRow extends PeopleRow {
    // detail
    @ExcelField(headName = "岗位名称")
    private String position_title;
    @ExcelField(headName = "职务")
    private String job;
    @ExcelField(headName = "社会职务")
    private String social_job;
    @ExcelField(headName = "历史获奖情况")
    private String achievements;
    @ExcelField(headName = "是否博导")
    private String is_phd_mentor;
    @ExcelField(headName = "是否硕导")
    private String is_master_mentor;
    @ExcelField(headName = "是否工会成员")
    private String is_union_member;
    @ExcelField(headName = "工资卡卡号")
    private String salary_card_no;
    @ExcelField(headName = "开户行")
    private String bank;
    @ExcelField(headName = "合同号")
    private String contract_no;
    @ExcelField(headName = "合同开始日期")
    private String contract_start_date;
    @ExcelField(headName = "合同结束日期")
    private String contract_end_date;

    public static PeopleResearcherRow render(PeopleResearcher detail) {
        PeopleResearcherRow row = new PeopleResearcherRow();
        if (detail == null) return row;

        row.position_title = detail.getPosition_title();
        row.job = detail.getJob();
        row.social_job = detail.getSocial_job();
        row.achievements = detail.getAchievements();
        row.is_phd_mentor = FormatUtil.format(detail.getIs_phd_mentor());
        row.is_master_mentor = FormatUtil.format(detail.getIs_master_mentor());
        row.is_union_member = FormatUtil.format(detail.getIs_union_member());
        row.salary_card_no = detail.getSalary_card_no();
        row.bank = detail.getBank();
        row.contract_no = detail.getContract_no();
        row.contract_start_date = FormatUtil.formatDate(detail.getContract_start_date());
        row.contract_end_date = FormatUtil.formatDate(detail.getContract_end_date());

        return row;
    }

    public static PeopleResearcher loadDetail(PeopleResearcherRow row) {
        PeopleResearcher detail = new PeopleResearcher();

        detail.setPosition_title(row.position_title);
        detail.setJob(row.job);
        detail.setSocial_job(row.social_job);
        detail.setAchievements(row.achievements);
        detail.setIs_phd_mentor(FormatUtil.toBoolean(row.is_phd_mentor));
        detail.setIs_master_mentor(FormatUtil.toBoolean(row.is_master_mentor));
        detail.setIs_union_member(FormatUtil.toBoolean(row.is_union_member));
        detail.setSalary_card_no(row.salary_card_no);
        detail.setBank(row.bank);
        detail.setContract_no(row.contract_no);
        detail.setContract_start_date(FormatUtil.formatDate(row.contract_start_date));

        return detail;
    }
}
