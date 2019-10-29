package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.people.People;

import java.util.Date;

public class ExpOtherVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String subject;
    private String matter;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;
}
