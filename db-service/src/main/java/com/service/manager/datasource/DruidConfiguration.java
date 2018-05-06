package com.service.manager.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Druid on 2018/5/6.
 *
 */
@Configuration("druidConfiguration")
@EnableTransactionManagement(proxyTargetClass = true)
@Import({DruidNonWebConfiguration.class, DruidWebConfiguration.class})
public class DruidConfiguration {
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
