package com.room.mixweb.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:352019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
@Configuration
public class ConfigureforCondition {
    @Bean
    @Conditional(WindowsCondition.class)
    public String windowsService(){

        return "dir";
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public String linuxService(){

        return "ls";
    }
}
