package com.room.mixweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 3:392019/3/30
 * @Modificd By:
 * @At : MixWeb
 */
@Component
public class UserService implements ApplicationEventPublisherAware {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void findUser(ApplicationContext applicationContext){
        System.out.println("查询所有的用户！");
        if (applicationEventPublisher==null){
            System.out.println("Fuck  YOu");
        }
        applicationContext.publishEvent(new EventOnFindUser("Dong Test"));


    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }
}
