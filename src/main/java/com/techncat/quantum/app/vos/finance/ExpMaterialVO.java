package com.techncat.quantum.app.vos.finance;

import lombok.Data;

import java.util.Date;

@Data
public class ExpMaterialVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
}
