/*
* MyBatisScan.java
* Created on  202015/6/3 21:48
* 版本       修改时间          作者      修改内容
* V1.0.1    202015/6/3       longshihui    初始版本
*
*/
package com.aaron.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 该注解的作用跟Component、Repository一样，在配置文件里面完全用这两个注解替换。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Component
public @interface RepositoryImpl {
    String value() default "";
}
