package com.room.mixweb.authorization.manager;

import org.springframework.stereotype.Component;

/**
 * @Author:dong
 * @Despriction: 授权信息管理器，用于获取用户授权和同步授权信息
 * @Date:my Create in 15:23 2019/3/19
 * @Modify by:
 */
@Component
public interface AuthenticationManager {
    String USER_AUTH_CACHE_NAME="user-auth-";

}
