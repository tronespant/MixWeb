package com.room.mixweb;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.DruidDataSourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 0:552019/3/30
 * @Modificd By:
 * @At : MixWeb
 */
@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.name}")
    private String name;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.maxActive}")
    private int maxActive;
    @Value("${jdbc.maxIdel}")
    private int maxIdel;
    @Value("${jdbc.maxWait}")
    private long maxWait;

    @Bean(destroyMethod = "close")
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(maxIdel);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }


}
