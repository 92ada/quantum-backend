package com.techncat.quantum.app.excel.model.people;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.common.voenhance.annotation.Visible;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [{
 * value: 300123199901014444
 * type: string
 * index: identity_no
 * },
 * {
 * value: 300123199901014444
 * type: enum
 * index: type
 * options: ["admin", "researcher"]
 * }
 * {
 * value: [
 * {
 * value: null
 * type: string
 * index: description
 * },
 * ]
 * type: object
 * index: lab,
 * // option_url: "/api/labs/options"
 * }]
 */

@Data
public class PeopleRow {
    //    private Long id;
    @ExcelField(headName = "工号")
    private String sid;
    @ExcelField(headName = "照片链接", readRequire = false, writeRequire = false)
    private String identity_photo_url;
    // base info
    @ExcelField(headName = "人员类型")
    private String type = "base";
    @ExcelField(headName = "状态", readRequire = false, writeRequire = false)
    private String status = "normal";
    @ExcelField(headName = "姓名")
    private String name;
    @ExcelField(headName = "证件类型")
    private String identity_type;
    @ExcelField(headName = "证件号码")
    private String identity_no;
    @Visible(requiredRoles = {Visible.ROLE.root, Visible.ROLE.admin})
    @ExcelField(headName = "出生日期")
    private String birth_date;
    @ExcelField(headName = "办公电话")
    private String office_phone;
    @ExcelField(headName = "移动电话")
    private String mobile_phone;
    @ExcelField(headName = "办公地址")
    private String office_address;
    @ExcelField(headName = "邮箱")
    private String email;
    @ExcelField(headName = "政治面貌")
    private String political_status;
    @ExcelField(headName = "个人简介")
    private String description;
    @ExcelField(headName = "紧急联系人")
    private String emergency_contact;
    @ExcelField(headName = "入职时间")
    private String entry_date;
    @ExcelField(headName = "离职时间")
    private String departure_date;
    @ExcelField(headName = "性别")
    private String gender;
    //    @ValueType(value = "lab", option_url = "/api/labs/options")
//    private Lab lab;
    @ExcelField(headName = "实验室", readRequire = false)
    private String labName;

    public static PeopleRow render(People people) {
        PeopleRow row = new PeopleRow();
//        row.id = people.getId();
        row.sid = people.getSid();
        row.identity_photo_url = people.getIdentity_photo_url();
        if (people.getType() != null)
            row.type = people.getType().name();
        if (people.getStatus() != null)
            row.status = people.getStatus().name();
        row.name = people.getName();
        if (people.getIdentity_type() != null)
            row.identity_type = people.getIdentity_type().name();
        row.identity_no = people.getIdentity_no();
        row.office_phone = people.getOffice_phone();
        row.mobile_phone = people.getMobile_phone();
        row.office_address = people.getOffice_address();
        row.email = people.getEmail();
        row.political_status = people.getPolitical_status();
        row.description = people.getDescription();
        row.emergency_contact = people.getEmergency_contact();
        if (people.getGender() != null)
            row.gender = people.getGender().name();
        if (people.getLab() != null)
            row.labName = renderLabs(people.getLab());

        row.birth_date = FormatUtil.formatDate(people.getBirth_date());
        row.entry_date = FormatUtil.formatDate(people.getEntry_date());
        row.departure_date = FormatUtil.formatDate(people.getDeparture_date());
        return row;
    }

    private static String renderLabs(List<Lab> labs) {
        return String.join(",", labs.parallelStream().map(Lab::getName).collect(Collectors.toList()));
    }

    public static People load(PeopleRow row) {
        if (row.sid == null || row.sid.trim().length() == 0) return null;
        People people = new People();
//        people.setId(row.id);
        people.setSid(row.sid);
        people.setIdentity_photo_url(row.identity_photo_url);
        people.setName(row.name);
        people.setIdentity_no(row.identity_no);
        people.setOffice_phone(row.office_phone);
        people.setMobile_phone(row.mobile_phone);
        people.setOffice_address(row.office_address);
        people.setEmail(row.email);
        people.setPolitical_status(row.political_status);
        people.setDescription(row.description);
        people.setEmergency_contact(row.emergency_contact);
        people.setLab(null); // 实验室不可进行导入操作（跨表）

        people.setBirth_date(FormatUtil.formatDate(row.birth_date));
        people.setEntry_date(FormatUtil.formatDate(row.entry_date));
        people.setDeparture_date(FormatUtil.formatDate(row.departure_date));
        people.setType(FormatUtil.formatEnum(People.Type.class, row.type));
        people.setStatus(FormatUtil.formatEnum(People.Status.class, row.status));
        people.setIdentity_type(FormatUtil.formatEnum(People.IdentityType.class, row.identity_type));
        people.setGender(FormatUtil.formatEnum(People.Gender.class, row.gender));
        return people;
    }

    private static List<Lab> loadLabs(String labNames) {
        String[] names = labNames.replaceAll("，", ",").split(",");
        // TODO..
        // find in db
        return new ArrayList<>();
    }
}
