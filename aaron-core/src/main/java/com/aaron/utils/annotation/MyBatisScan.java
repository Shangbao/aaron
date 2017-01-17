/*
* MyBatisScan.java
* Created on  202015/6/3 21:48
* 版本       修改时间          作者      修改内容
* V1.0.1    202015/6/3       longshihui    初始版本
*
*/
package com.aaron.utils.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 类的描述信息
 *
 * @author aaron_yong
 * @version 1.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Component
public @interface MyBatisScan {
    String value() default "";
}
