package com.room.mixweb.authorization.define;

import com.room.mixweb.authorization.manager.Authentication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author:dong
 * @Despriction: 控制上下文
 * @Date:my Create in 21:03 2019/3/21
 * @Modify by:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizingContext {
    private Authentication authentication;

}
