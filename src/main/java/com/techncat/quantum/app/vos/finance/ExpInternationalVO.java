package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpInternational;
import com.techncat.quantum.app.model.people.People;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Set;

public class ExpInternationalVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private Date start_date;
    private Date end_date;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String peopleJson;

    private String matter;
    private String location;
    private Integer number_of_people;

    public ExpInternationalVO(Exp exp, ExpInternational expInternational) {
        super(exp);
        copyProperties(expInternational);
    }

    private void copyProperties(ExpInternational expInternational) {
        if (null == expInternational) return;
        Long id = this.getId();
        Date createdAt = this.getCreatedAt();
        Date updatedAt = this.getUpdateAt();
        BeanUtils.copyProperties(expInternational, this);
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setUpdateAt(updatedAt);
    }
}
