package com.room.mixweb.authorization;

import com.room.mixweb.authorization.logging.AccessLogger;
import com.room.mixweb.authorization.manager.Authentication;
import com.room.mixweb.authorization.manager.AuthenticationManager;
import com.room.mixweb.listener.even.AuthoricationExitEvent;
import com.room.mixweb.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.room.mixweb.message.ResponseMessage.ok;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 14:51 2019/3/19
 * @Modify by:
 */
@RestController
@RequestMapping("")
@AccessLogger(value = "授权",ingore = false)
public class AuthrizationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping({"/login-out","/sign-out","/exit"})
    public ResponseMessage exit(Authentication authentication){
        eventPublisher.publishEvent(new AuthoricationExitEvent(authentication));
        return ok();
    }
}
