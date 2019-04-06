package com.room.mixweb.authorization.logging;

import java.lang.annotation.*;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 14:59 2019/3/19
 * @Modify by:
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

public @interface AccessLogger {
    /**
     * @return 对类或方法的简单说明
     * @see AccessLoggerInfo#getAction
     */
    String value();

    /**
     * @return 对类或方法的详细说明
     */
    String[] describe() default "";

    /**
     *
     * @returns是否取消日志记录，如果不想记录
     */
    boolean ingore()default false;
}

