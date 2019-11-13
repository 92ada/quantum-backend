package com.techncat.quantum.app.auth.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TokenEntity {
    private String access_token;
    private String refresh_token;
    private String type;
    private Date issue_date;
    private Date access_token_expiration_date;
    private Date refresh_token_expiration_date;
    private String issue_provider = "ForkTea";
    private String website = "https://forktea.com";
    private String version = "1.0.0-RELEASE";
}
