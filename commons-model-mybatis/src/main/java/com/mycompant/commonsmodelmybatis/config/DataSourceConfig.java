package com.mycompant.commonsmodelmybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 19:272019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
@Configuration
public class DataSourceConfig {
    @Qualifier("dataSource")
    @Autowired
    private HikariDataSource dataSource;
    @Bean(destroyMethod = "close")
    public HikariDataSource getDataSource(){

        return dataSource;
    }
}
