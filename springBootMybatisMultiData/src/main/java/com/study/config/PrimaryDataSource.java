package com.study.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * @author liuxin
 * @Title: PrimaryDataSource
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1210:47
 */
@Configuration

@MapperScan(basePackages = "com.study.dao.primary",sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class PrimaryDataSource {
    @Bean(name = "primaryData")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "primaryFactory")
    @Primary
    public SqlSessionFactory getFactory(@Qualifier(value = "primaryData") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/primaryMapper/*.xml"));
        return bean.getObject();
    }
    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("primaryData") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("primaryFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}