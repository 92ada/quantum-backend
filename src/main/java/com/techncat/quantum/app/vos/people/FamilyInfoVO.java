package com.techncat.quantum.app.vos.people;

import lombok.Data;

import java.util.Date;

@Data
public class FamilyInfoVO {
    private String name;
    private String relationship;
    private String identity_type;
    private String identity_no;
    private Date birth_date;
    private String phone;
    private String email;
    private String political_status;
    private String remark;
}
