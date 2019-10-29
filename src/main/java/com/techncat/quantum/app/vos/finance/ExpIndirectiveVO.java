package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpIndirective;
import com.techncat.quantum.app.model.people.People;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class ExpIndirectiveVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String subject;
    private String matter;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;

    public ExpIndirectiveVO(Exp exp, ExpIndirective expIndirective) {
        super(exp);
        copyProperties(expIndirective);
    }

    private void copyProperties(ExpIndirective expIndirective) {
        if (null == expIndirective) return;
        Long id = this.getId();
        Date createdAt = this.getCreatedAt();
        Date updatedAt = this.getUpdateAt();
        BeanUtils.copyProperties(expIndirective, this);
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setUpdateAt(updatedAt);
    }
}
