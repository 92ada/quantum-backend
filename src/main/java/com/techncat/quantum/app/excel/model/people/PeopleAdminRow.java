package com.techncat.quantum.app.excel.model.people;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.PeopleAdmin;
import lombok.Data;

@Data
public class PeopleAdminRow extends PeopleRow {
    // detail
    @ExcelField(headName = "是否工会成员")
    private String is_union_member;
    @ExcelField(headName = "银行卡号")
    private String salary_card_no;
    @ExcelField(headName = "开户行")
    private String bank;


    public static PeopleAdminRow render(PeopleAdmin detail) {
        PeopleAdminRow row = new PeopleAdminRow();
        if (detail == null) return row;

        row.is_union_member = FormatUtil.format(detail.getIs_union_member());
        row.salary_card_no = detail.getSalary_card_no();
        row.bank = detail.getBank();

        return row;
    }

    public static PeopleAdmin loadDetail(PeopleAdminRow row) {
        PeopleAdmin detail = new PeopleAdmin();

        detail.setIs_union_member(FormatUtil.toBoolean(row.is_union_member));
        detail.setSalary_card_no(row.salary_card_no);
        detail.setBank(row.bank);

        return detail;
    }
}
