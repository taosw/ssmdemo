package com.tao.ssmdemo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TAO on 2018/10/2.
 */
//配置mybatis的mapper扫描路径
@Configuration
@MapperScan("com.tao.ssmdemo.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource() throws Exception{
       ComboPooledDataSource dataSource = new ComboPooledDataSource();
       dataSource.setDriverClass(jdbcDriver);
       dataSource.setJdbcUrl(jdbcUrl);
       dataSource.setUser(jdbcUsername);
       dataSource.setPassword(jdbcPassword);
       //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }

}
