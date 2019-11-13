package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class ExpIndirectiveVO {
    private Long id;

    private String subject;
    private String matter;

    @ValueType(value = "people", option_url = "/api/people/options")
    private Object handlerJson;
}
