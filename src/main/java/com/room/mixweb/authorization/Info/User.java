package com.room.mixweb.authorization.Info;

import java.io.Serializable;

/**
 * 用户信息
 * @author dong
 * @date
 */
public interface User extends Serializable {
    /**
     *
     * @return 用户id
     */
    String getId();

    /**
     *
     * @return 用户名
     */
    String getUserName();
    /**
    *@Description:
    *@Date:
     * @return 姓名
    */
    String getName();

    /**
     * 用户类型
     * @return
     */
    String getType();
}


