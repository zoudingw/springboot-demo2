package com.zdw.springboot.study.demo2.demo.datasourceConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Configuration
@MapperScan(basePackages = "com.zdw.springboot.study.demo2.demo.mapper.test1",sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSourceTest1Config {
    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSesionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/test1/*.xml"));
        return bean.getObject();
    }

    @Bean("test1TransactionManager")
    @Primary
    public DataSourceTransactionManager test1DataSourceTransactionManager(@Qualifier("test1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate test1SessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
