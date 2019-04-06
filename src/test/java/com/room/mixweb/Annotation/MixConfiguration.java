package com.room.mixweb.Annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:492019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface MixConfiguration {
    String[] value() default {};
}
