package com.techncat.quantum.app.excel.model.people;

import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.PeopleVisitor;
import lombok.Data;

@Data
public class PeopleVisitorRow extends PeopleRow {
    // detail
    private String position_title;
    private String salary_card_no;
    private String bank;
    private String citizenship;
    private String institution;
    private String research_direction;
    private String salary;
    private String remark;

    public static PeopleVisitorRow render(PeopleVisitor detail) {
        PeopleVisitorRow row = new PeopleVisitorRow();
        if (detail == null) return row;

        row.position_title = detail.getPosition_title();
        row.salary_card_no = detail.getSalary_card_no();
        row.bank = detail.getBank();
        row.citizenship = detail.getCitizenship();
        row.institution = detail.getInstitution();
        row.research_direction = detail.getResearch_direction();
        row.salary = FormatUtil.format(detail.getSalary());
        row.remark = detail.getRemark();

        return row;
    }

    public static PeopleVisitor loadDetail(PeopleVisitorRow row) {
        PeopleVisitor detail = new PeopleVisitor();

        detail.setPosition_title(row.position_title);
        detail.setSalary_card_no(row.salary_card_no);
        detail.setBank(row.bank);
        detail.setCitizenship(row.citizenship);
        detail.setInstitution(row.institution);
        detail.setResearch_direction(row.research_direction);
        detail.setSalary(FormatUtil.toBigDecimal(row.salary));
        detail.setRemark(row.remark);

        return detail;
    }
}
