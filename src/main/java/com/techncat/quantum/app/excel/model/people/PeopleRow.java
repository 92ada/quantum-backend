package com.techncat.quantum.app.excel.model.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.common.voenhance.annotation.Visible;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.util.Date;

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
    private Long id;
    private String sid;
    private String identity_photo_url;
    // base info
    @ValueType("enumerated")
    private People.Type type;
    @ValueType("enumerated")
    private People.Status status;
    private String name;
    @ValueType("enumerated")
    private People.IdentityType identity_type;
    private String identity_no;
    @Visible(requiredRoles = {Visible.ROLE.root, Visible.ROLE.admin})
    private Date birth_date;
    private String office_phone;
    private String mobile_phone;
    private String office_address;
    private String email;
    private String political_status;
    private String description;
    private String emergency_contact;
    private Date entry_date;
    private Date departure_date;
    @ValueType("enumerated")
    private People.Gender gender;
    //    @ValueType(value = "lab", option_url = "/api/labs/options")
//    private Lab lab;
    private String labName;

    public static PeopleRow render(People people) {
        PeopleRow row = new PeopleRow();
        row.id = people.getId();
        row.sid = people.getSid();
        row.identity_photo_url = people.getIdentity_photo_url();
        row.type = people.getType();
        row.status = people.getStatus();
        row.name = people.getName();
        row.identity_type = people.getIdentity_type();
        row.identity_no = people.getIdentity_no();
        row.birth_date = people.getBirth_date();
        row.office_phone = people.getOffice_phone();
        row.mobile_phone = people.getMobile_phone();
        row.office_address = people.getOffice_address();
        row.email = people.getEmail();
        row.political_status = people.getPolitical_status();
        row.description = people.getDescription();
        row.emergency_contact = people.getEmergency_contact();
        row.entry_date = people.getEntry_date();
        row.departure_date = people.getDeparture_date();
        row.gender = people.getGender();
        if (people.getLab() != null)
            row.labName = people.getLab().getName();
        return row;
    }

    public static People load(PeopleRow row) {
        People people = new People();
        people.setId(row.id);
        people.setSid(row.sid);
        people.setIdentity_photo_url(row.identity_photo_url);
        people.setType(row.type);
        people.setStatus(row.status);
        people.setName(row.name);
        people.setIdentity_type(row.identity_type);
        people.setIdentity_no(row.identity_no);
        people.setBirth_date(row.birth_date);
        people.setOffice_phone(row.office_phone);
        people.setMobile_phone(row.mobile_phone);
        people.setOffice_address(row.office_address);
        people.setEmail(row.email);
        people.setPolitical_status(row.political_status);
        people.setDescription(row.description);
        people.setEmergency_contact(row.emergency_contact);
        people.setEntry_date(row.entry_date);
        people.setDeparture_date(row.departure_date);
        people.setGender(row.gender);
        people.setLab(null); // 实验室不可进行导入操作（跨表）
        return people;
    }
}
