package com.mycompant.commonsmodelmybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 19:492019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
@Configuration
@ConditionalOnClass(DataSourceConfig.class)
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;
    @Bean(name = "sqlSessionFactory")
   public SqlSessionFactory getSqlSessionFactory(){
       SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
       try {
           return sessionFactoryBean.getObject();
       } catch (Exception e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       }

   }

    /**
     * 获取sqlsessiont模板
     * @return
     */
   public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
       return new SqlSessionTemplate(sqlSessionFactory);
   }
    /**
     * 启动事务
     * @return
     */
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
