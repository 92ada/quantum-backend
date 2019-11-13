package com.techncat.quantum.app.auth.entity;

import java.util.List;

/**
 * provide for jwt encode/decode, and controller method parameter
 */
public class Aser {
    private Long userId;
    private List<String> roles;
    private boolean isExpiration;

    public Aser(Long userId, List<String> roles, boolean isExpiration) {
        this.userId = userId;
        this.roles = roles;
        this.isExpiration = isExpiration;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isExpiration() {
        return isExpiration;
    }

    public void setExpiration(boolean expiration) {
        isExpiration = expiration;
    }
}
