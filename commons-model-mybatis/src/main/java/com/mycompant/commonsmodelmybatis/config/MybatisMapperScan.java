package com.mycompant.commonsmodelmybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 20:032019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
@Configuration
@ConditionalOnClass(MybatisConfig.class)
public class MybatisMapperScan {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer=new MapperScannerConfigurer();
        configurer.setBasePackage("com.mycompant.commonsmodelmybatis.dao");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }
}
