package com.techncat.quantum.app.model.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_role_items")
public class UserRoleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "role_key")
    private String key; // set to user_roles

    @Transient
    private Boolean hasAuth;
}
