package com.room.mixweb.authorization.access;

/**
 * @Author:dong
 * @Despriction:
 * 数据级权限控制器，如：A用户只能查询自己创建的B数据 A用户只能修改自己创建的B数据
 * @Date:my Create in 20:41 2019/3/21
 * @Modify by:
 */
public interface DataAccessController {
    /**
     * 执行权限控制
     * @param accessConfig
     * @return 授权是否通过
     */
    boolean doAccess(DataAccessConfig accessConfig);
}
