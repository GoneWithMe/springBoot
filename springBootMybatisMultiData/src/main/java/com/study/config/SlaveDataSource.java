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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author liuxin
 * @Title: SlaveDataSource
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1214:11
 */
@Configuration
@MapperScan(basePackages = "com.study.dao.slave",sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class SlaveDataSource {
    @Bean(name = "slaveData")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "slaveFactory")
    public SqlSessionFactory getFactory(@Qualifier(value = "slaveData") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/slaveMapper/*.xml"));
        return bean.getObject();
    }
    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("slaveData") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "slaveSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("slaveFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
