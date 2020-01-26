package com.techncat.quantum.app.excel.model.people;

import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.PeopleAdmin;
import lombok.Data;

@Data
public class PeopleAdminRow extends PeopleRow {
    // detail
    private String is_union_member;
    private String salary_card_no;
    private String bank;
    private String contract_no;
    private String contract_start_date;
    private String contract_end_date;
    private String annual_salary;
    private String monthly_salary;
    private String housing_subsidy;

    public static PeopleAdminRow render(PeopleAdmin detail) {
        PeopleAdminRow row = new PeopleAdminRow();
        if (detail == null) return row;

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

    public static PeopleAdmin loadDetail(PeopleAdminRow row) {
        PeopleAdmin detail = new PeopleAdmin();

        detail.setIs_union_member(FormatUtil.toBoolean(row.is_union_member));
        detail.setSalary_card_no(row.salary_card_no);
        detail.setBank(row.bank);
        detail.setContract_no(row.contract_no);
        detail.setContract_start_date(FormatUtil.formatDate(row.contract_start_date));
        detail.setContract_end_date(FormatUtil.formatDate(row.contract_end_date));
        detail.setAnnual_salary(FormatUtil.toBigDecimal(row.annual_salary));
        detail.setMonthly_salary(FormatUtil.toBigDecimal(row.monthly_salary));
        detail.setHousing_subsidy(FormatUtil.toBigDecimal(row.housing_subsidy));

        return detail;
    }
}
