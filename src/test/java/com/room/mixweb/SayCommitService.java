package com.room.mixweb;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 3:362019/3/30
 * @Modificd By:
 * @At : MixWeb
 */
@Component
public class SayCommitService implements ApplicationListener<EventOnFindUser> {

    @Override
    public void onApplicationEvent(EventOnFindUser eventOnFindUser) {
        System.out.println("I can hear you!!");
    }
}
