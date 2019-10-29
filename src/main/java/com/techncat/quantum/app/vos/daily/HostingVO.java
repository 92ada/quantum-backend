package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.model.people.People;

import java.util.Date;

public class HostingVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private People inviter;
    private Date time;
    private String title;
    private String site;
    private Boolean is_reimbursement;
}
