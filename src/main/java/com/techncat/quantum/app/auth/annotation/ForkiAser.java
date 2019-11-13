package com.techncat.quantum.app.auth.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForkiAser {
    String[] requiredRoles() default {};
}
