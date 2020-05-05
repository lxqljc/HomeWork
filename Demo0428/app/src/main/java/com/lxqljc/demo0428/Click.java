package com.lxqljc.demo0428;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: luoxiaoquan
 * Date: 2020-05-05
 * description: 自定义Click注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Click {

     int[] value();
}
