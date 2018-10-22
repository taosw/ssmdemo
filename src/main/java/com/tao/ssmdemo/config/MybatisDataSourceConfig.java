package com.tao.ssmdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by TAO on 2018/9/30.
 */
////@Configuration
////@MapperScan(basePackages = "com.tao.ssmdemo.dao",sqlSessionTemplateRef = "mybatisSqlSessionTemplate")
public class MybatisDataSourceConfig {
  /*  @Bean("mybatisDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource mybatisDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="mybatisSqlsessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("mybatisDataSource")
        DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper*//**//*.xml"));
        return bean.getObject();
    }

    @Bean(name="mybatisTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(
        @Qualifier("mybatisDataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="mybatisSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("mybatisSqlsessionFactory")
            SqlSessionFactory sqlSessionFactory){
            return new SqlSessionTemplate(sqlSessionFactory);
    }
*/
}


