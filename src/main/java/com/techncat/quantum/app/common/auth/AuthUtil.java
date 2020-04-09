package com.techncat.quantum.app.common.auth;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.auth.annotation.Visible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUtil {
    @Autowired
    private AuthHandler authHandler;

//    public <T> T process(@ForkiAser Aser aser, T data) throws IllegalAccessException {
//        Visible.ROLE[] roles = aser.getRoles().stream().map(Visible.ROLE::valueOf).toArray(Visible.ROLE[]::new);
//        return authHandler.preload(roles, data);
//    }
    // 没写好
}
