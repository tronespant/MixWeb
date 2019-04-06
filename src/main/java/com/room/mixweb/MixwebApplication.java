package com.room.mixweb;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author my
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class MixwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MixwebApplication.class, args);
    }

}
