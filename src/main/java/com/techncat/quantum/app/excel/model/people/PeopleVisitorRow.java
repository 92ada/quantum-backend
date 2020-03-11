package com.techncat.quantum.app.excel.model.people;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.PeopleVisitor;
import lombok.Data;

@Data
public class PeopleVisitorRow extends PeopleRow {
    // detail
    @ExcelField(headName = "岗位名称")
    private String position_title;
    @ExcelField(headName = "工资卡卡号")
    private String salary_card_no;
    @ExcelField(headName = "开户行")
    private String bank;
    @ExcelField(headName = "国籍")
    private String citizenship;
    @ExcelField(headName = "单位")
    private String institution;
    @ExcelField(headName = "研究领域")
    private String research_direction;
    @ExcelField(headName = "备注")
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
        detail.setRemark(row.remark);

        return detail;
    }
}
