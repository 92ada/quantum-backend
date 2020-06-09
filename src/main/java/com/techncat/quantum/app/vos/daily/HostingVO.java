package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.voenhance.annotation.Required;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class HostingVO {
    private Long id;


    @Required(true)
    @ValueType("datetime")
    private Date time;
    @Required(true)
    private String title;
    private String site;
    private Boolean is_reimbursement;
}
