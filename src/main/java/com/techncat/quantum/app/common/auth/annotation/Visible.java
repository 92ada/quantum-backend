package com.techncat.quantum.app.common.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Visible {
    enum ROLE {
        root("root"), admin("admin");

        String value;

        ROLE(String value) {
            this.value = value;
        }
    }

    ROLE[] requiredRoles() default {};
}
