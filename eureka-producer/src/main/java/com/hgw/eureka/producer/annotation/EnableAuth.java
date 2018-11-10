package com.hgw.eureka.producer.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableAuth {
    boolean auth() default true;

    String value() default "";
}
