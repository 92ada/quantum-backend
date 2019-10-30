package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.model.finance.Exp;

import java.util.Date;

public class ExpProcessingVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String subject;
    private String content;
}