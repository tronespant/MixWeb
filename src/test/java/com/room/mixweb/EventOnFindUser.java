package com.room.mixweb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 3:322019/3/30
 * @Modificd By:
 * @At : MixWeb
 */
public class EventOnFindUser extends ApplicationEvent {

    public EventOnFindUser(Object source) {
        super(source);
    }
}
