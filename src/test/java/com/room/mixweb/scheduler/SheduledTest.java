package com.room.mixweb.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:112019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
@Service
public class SheduledTest {
    static final SimpleDateFormat date=new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每5秒执行一次："+date.format(new Date()));
    }
    @Scheduled(cron = "0 24 21 ? * *")
    public void fixTimeExcecution(){
        System.out.println("指定时间执行一次："+date.format(new Date()));
    }
}
