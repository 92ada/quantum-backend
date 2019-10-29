package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.annotation.ValueType;

import java.util.Date;

public class HostingVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String inviterJson;
    private Date time;
    private String title;
    private String site;
    private Boolean is_reimbursement;
}
