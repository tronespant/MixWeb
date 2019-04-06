package com.room.mixweb.listener.even;


import com.room.mixweb.authorization.manager.Authentication;
import org.springframework.context.ApplicationEvent;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 19:59 2019/3/21
 * @Modify by:
 */
public class AuthoricationExitEvent extends ApplicationEvent implements AuthorizationEvent {
    private Authentication authentication;
    public AuthoricationExitEvent(Authentication authentication) {
        super(authentication);
        this.authentication=authentication;
    }
    public Authentication getAuthentication(){
        return authentication;
    }
}
