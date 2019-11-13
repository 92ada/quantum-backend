package com.techncat.quantum.app.auth.entity;

import java.util.List;

/**
 * provide for jwt encode/decode, and controller method parameter
 */
public class Aser {
    private String sid;
    private List<String> roles;
    private boolean isExpiration;

    public Aser(String userId, List<String> roles, boolean isExpiration) {
        this.sid = userId;
        this.roles = roles;
        this.isExpiration = isExpiration;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
