package com.techncat.quantum.app.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "users_sid_index", columnList = "sid", unique = true)
        })
public class User {
    @Id
    @Column(length = 14)
    private String sid;

    @Column(columnDefinition = "text")
    private String roles;

    public List<String> getRoles() {
        List<String> authorities = new ArrayList<>();
        if (roles == null) return new ArrayList<>();
        Arrays.stream(roles.split(",")).forEach(role ->
                authorities.add(role));
        return authorities;
    }

    public void setRoles(List<String> roles) {
        this.roles = String.join(",", roles);
    }
}
