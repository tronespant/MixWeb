package com.room.mixweb.authorization.annotation;


import com.room.mixweb.authorization.define.Logical;
import com.room.mixweb.authorization.define.Phased;

import java.lang.annotation.*;

/**
 * 基础权限控制注解 提供基本的控制配置
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 20:11 2019/3/21
 * @Modify by:
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Authorize {
    /**
     * 对角色授权，当使用按角色授权时，对模块以及操作级别授权方式失效
     * @return
     */
    String[] role() default {};

    /**
     * 对模块授权
     * @return
     */
    String[] permission() default {};

    /**
     * 动作授权 如增删改查等
     * @return
     */
    String[] action() default {};

    /**
     * 验证是否为指定用户
     * @return
     */
    String[] user() default {};

    /**
     * 验证失败时返回的信息
     * @return
     */
    String message() default "无权限";

    /**
     * 是否合并类上的注解
     * @return
     */
    boolean merge() default true;
    /**
     * 验证模式，在使用多个验证条件时有效
     *
     * @return logical
     */
    Logical logical() default Logical.DEFAULT;

    /**
     * 验证时机 方法调用前还是调用后
     * @return
     */
    Phased phased() default Phased.before;

    /**
     * 是否忽略，忽略后将不进行权限控制
     * @return
     */
    boolean ignore() default false;

    /**
     * 数据权限控制
     * @return
     */
    RequiresDataAccess dataAccess() default @RequiresDataAccess(ignore = true);
    String[] description() default {};
}
