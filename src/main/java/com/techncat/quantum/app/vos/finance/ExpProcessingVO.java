package com.techncat.quantum.app.vos.finance;

import lombok.Data;

import java.util.Date;

@Data
public class ExpProcessingVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String subject;
    private String content;
}
