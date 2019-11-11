package com.techncat.quantum.app.common.voenhance.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Visible {
    enum ROLE {
        root, admin
    }
    ROLE[] requiredRoles() default {};
}
