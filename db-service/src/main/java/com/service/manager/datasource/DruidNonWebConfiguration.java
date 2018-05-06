package com.service.manager.datasource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Druid on 2018/5/6.
 *
 */
@Configuration(value = "druidNonWebConfiguration")
@EnableConfigurationProperties(DruidProperties.class)
public class DruidNonWebConfiguration {

    private Logger logger = LoggerFactory.getLogger(DruidNonWebConfiguration.class);

    @Primary
    @Bean(destroyMethod = "close", initMethod = "init",name = "dataSource")
    public DataSource dataSource(DruidProperties ds, ApplicationContext context) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource(false);
        if (ds.getId() != null) {
            druidDataSource.setName(ds.getId());
        }
        druidDataSource.setUsername(ds.getUsername());
        druidDataSource.setUrl(ds.getUrl());
        druidDataSource.setPassword(ds.getPassword());
        if (StringUtils.hasText(ds.getFilters())) {
            druidDataSource.setFilters(ds.getFilters());
        }
        if (StringUtils.hasText(ds.getProxyFilters())) {
            String result[] = StringUtils.split(ds.getProxyFilters(), ",");
            Filter filter;
            List<Filter> filterList = new ArrayList<Filter>();
            for (int i = 0; i < result.length; i++) {
                try {
                    filter = (Filter) context.getBean(result[i]);
                    filterList.add(filter);
                } catch (Exception ex) {
                    logger.error("连接池配置信息错误:" + ex.getMessage());
                }
            }
            if (!CollectionUtils.isEmpty(filterList)) {
                druidDataSource.setProxyFilters(filterList);
            }
        }
        druidDataSource.setMaxActive(ds.getMaxActive());
        druidDataSource.setInitialSize(ds.getInitialSize());
        druidDataSource.setMaxWait(ds.getMaxWait());
        druidDataSource.setMinIdle(ds.getMinIdle());
        druidDataSource.setTimeBetweenEvictionRunsMillis(ds.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(ds.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(ds.getValidationQuery());
        druidDataSource.setTestWhileIdle(ds.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(ds.isTestOnBorrow());
        druidDataSource.setTestOnReturn(ds.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(ds.isPoolPreparedStatements());
        druidDataSource.setMaxOpenPreparedStatements(ds.getMaxOpenPreparedStatements());
        return druidDataSource;
    }


    @Bean(name = "stat-filter")
    public StatFilter statFilter(DruidProperties ds) {
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(ds.getSlowSqlMillis());
        statFilter.setLogSlowSql(ds.isLogSlowSql());
        return statFilter;
    }

    @Bean(name = "log-filter")
    public Slf4jLogFilter logFilter(DruidProperties ds) {
        Slf4jLogFilter logFilter = new Slf4jLogFilter();
        logFilter.setStatementExecutableSqlLogEnable(true);
        return logFilter;
    }


}
