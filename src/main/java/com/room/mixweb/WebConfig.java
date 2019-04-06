package com.room.mixweb;

import com.room.mixweb.controller.filter.MyFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 18:43 2019/3/12
 * @Modify by:Dong
 */
@Configuration
public class WebConfig {
    @Bean
    public RemoteIpFilter registraFilter(){

       return new RemoteIpFilter();
    }
    @Bean
    public FilterRegistrationBean registrationFilter(){
        FilterRegistrationBean registration=new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("initParamName","initParamValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }


}
