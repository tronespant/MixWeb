package com.room.mixweb.authorization.access;

/**
 * @Author:dong
 * @Despriction: 数据级的权限控制，此接口为控制方式配置
 * 具体的控制逻辑由控制器{@link DataAccessController} 实现
 * @Date:my Create in 20:51 2019/3/21
 * @Modify by:
 */
public interface DataAccessConfig {
    /**
     * 对数据的操作事件
     * @return
     * @see Permission#ACTION_ADD
     */
    String getAction();

    /**
     * 控制方式标识
     * @return
     * @see DefaultType
     */
    String getType();

    /**
     * 内置的控制方式
     */
    interface DefaultType{
        /**
         * 自己创建的字段
         */
        String OWN_CREATED="OWN_CREATED";
        /**
         * 字段范围
         */
        String FIELD_SCOPE="FIELD_SCOPE";
        /**
         * 字段过滤
         */
        String DENY_FIELDS="DENY_FIELDS";
        /**
         * 自定义脚本方式
         */
        String SCRIPT="SCRIPT";
        /**
         * 自定义控制器
         */
        String CUSTOM="CUSTOM";
    }


}
