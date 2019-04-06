package com.room.mixweb.authorization.annotation;

import com.room.mixweb.authorization.access.DataAccessController;
import com.room.mixweb.authorization.define.Logical;
import com.room.mixweb.authorization.define.Phased;

import java.lang.annotation.*;

/**
 * @Author:dong
 * @Despriction:
 * 数据级别权限控制注解 用于进行需要数据级别权限控制声明
 * 此注解仅用于声明此方法需要进行数据级别权限控制，具体权限控制方式有{@link DataAccessController}实现
 * @Date:my Create in 20:33 2019/3/21
 * @Modify by:
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiresDataAccess {
    /**
     *
     * @return permission id ,如果为空将继承{@link Authorize#permission()}
     */
    String permission() default "";

    /**
     * action id ,如果为空将继承{@link Authorize#action()} ()}
     * @return
     */
    String[] action() default {};

    String[] supportType() default {};
    /**
     * @return logical
     */
    Logical logical() default Logical.AND;

    /**
     * 自定义控制器bean名称
     * @return
     */
    String controllerBeanName() default "";

    /**
     * 自定义控制器类型
     * @return
     */
    Class<DataAccessController> controllerClass() default DataAccessController.class;

    /**
     * 同Authorize
     * @return
     */
    Phased phased() default Phased.before;

    /**
     *
     * @return id参数名称
     */
    String idParamName() default "id";

    /**
     * 是否忽略权限检查
     * @return
     */
    boolean ignore() default false;

    /**
     * 进行控制的实体类类型
     * @return
     */
    Class entityType() default Void.class;
}
