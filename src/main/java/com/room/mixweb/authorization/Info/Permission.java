package com.room.mixweb.authorization.Info;

import com.room.mixweb.authorization.access.DataAccessConfig;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

/**
 * @author dong
 * @see com.room.mixweb.authorization.manager.Authentication
 */
public interface Permission extends Serializable {

    /**
     * 查询
     */
    String ACTION_QUERY="query";
    /**
     * 获取明细
     */
    String ACTION_GET="get";
    /**
     * 新增
     */
    String ACTION_ADD="add";
    /**
     * 更新
     */
    String ACTION_UPDATE="update";
    /**
     * 删除
     */
    String ACTION_DELETE="delete";
    /**
     * 导入
     */
    String ACTION_IMPORT="import";
    /**
     * 禁用
     */
    String ACTION_DISABLE="disable";
    /**
     * 道出
     */
    String ACTION_EXPORT="export";
    /**
     * 启用
     */
    String ACTION_ENABLE="enable";
    String getId();
    String getName();

    /**
     * 用户对此权限的可操作事件（按钮）
     * ！：任何时候都不应该对返回的set进行写操作
     * @return 如果没有配置返回空{@link Collection#emptySet()},不会返回null
     * @see DataAccessConfig
     * @see com.room.mixweb.authorization.access.DataAccessController
     */
    Set<DataAccessConfig> getDataAccesses();
    default <T extends DataAccessConfig> Optional<T> findDataAccess(){
        return null;
    }
}
