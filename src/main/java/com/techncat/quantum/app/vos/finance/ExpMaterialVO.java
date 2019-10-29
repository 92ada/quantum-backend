package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.model.finance.Exp;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class ExpMaterialVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
}
