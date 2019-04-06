package com.room.mixweb.authorization;

/**
 * @Author:dong
 * @Despriction:令牌解析结果
 * @Date:my Create in 14:43 2019/3/19
 * @Modify by:
 */
public interface ParsedToken {
    /**
     * @return 令牌
     * */
    String getToken();
    /**
    *@return 令牌类型
     *
     * */
    String getType();
}
