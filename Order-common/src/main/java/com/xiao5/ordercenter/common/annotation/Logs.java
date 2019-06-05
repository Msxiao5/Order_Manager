package com.xiao5.ordercenter.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther: Wu Tianbing
 * @date: 2019/6/5/005 14:38
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logs {

    String value() default "";

    String type() default "OTHER";
}
