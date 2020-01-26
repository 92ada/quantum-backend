package com.techncat.quantum.app.excel.model.people;

import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.PeopleTeacher;
import lombok.Data;

@Data
public class PeopleTeacherRow extends PeopleRow {
    // detail
    private String position_title;
    private String job;
    private String social_job;
    private String achievements;
    private String is_phd_mentor;
    private String is_master_mentor;
    private String is_union_member;
    private String salary_card_no;
    private String bank;
    private String contract_no;
    private String contract_start_date;
    private String contract_end_date;
    private String annual_salary;
    private String monthly_salary;
    private String housing_subsidy;

    public static PeopleTeacherRow render(PeopleTeacher detail) {
        PeopleTeacherRow row = new PeopleTeacherRow();
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
        row.annual_salary = FormatUtil.format(detail.getAnnual_salary());
        row.monthly_salary = FormatUtil.format(detail.getMonthly_salary());
        row.housing_subsidy = FormatUtil.format(detail.getHousing_subsidy());

        return row;
    }

    public static PeopleTeacher loadDetail(PeopleTeacherRow row) {
        PeopleTeacher detail = new PeopleTeacher();

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
        detail.setAnnual_salary(FormatUtil.toBigDecimal(row.annual_salary));
        detail.setMonthly_salary(FormatUtil.toBigDecimal(row.monthly_salary));
        detail.setHousing_subsidy(FormatUtil.toBigDecimal(row.housing_subsidy));

        return detail;
    }
}
