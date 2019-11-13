package com.techncat.quantum.app.auth.service;


import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.auth.entity.LoginCodePair;
import com.techncat.quantum.app.auth.entity.TokenEntity;

import java.util.List;

public interface JwtService {

    /* TOKEN for user auth */

    TokenEntity encode(Long userId, List<String> roles);

    TokenEntity encode(Aser aser);

    Aser decode(String token);

    /* TOKEN for login code */

    LoginCodePair randomCreateCodePair(String subject);

    boolean verifyCodePair(LoginCodePair pair);

    boolean verifyCodePair(String ticket, String subject, String code);
}
