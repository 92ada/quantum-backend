package com.techncat.quantum.app.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface ValueType {
    String value() default "string";
    String option_url() default "";
}
