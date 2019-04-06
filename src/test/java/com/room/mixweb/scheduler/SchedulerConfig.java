package com.room.mixweb.scheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:162019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
@Configuration
@ComponentScan("com.room.mixweb.scheduler")
@EnableScheduling
public class SchedulerConfig {
}
