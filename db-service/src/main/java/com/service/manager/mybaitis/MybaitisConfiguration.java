package com.service.manager.mybaitis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Druid on 2018/4/22.
 *
 */
@Configuration(value = "mybatisConfiguration")
public class MybaitisConfiguration implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybaitisConfiguration.class);
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    private DataSource getDataSource() {
        return (DataSource) this.applicationContext.getBean(DataSource.class);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() throws SQLException, IOException {
        LOGGER.info("init sqlSessionFactory");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage(this.applicationContext.getEnvironment().getProperty("mybatis.typeAliasesPackage"));
        //mapper文件位置
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:" + this.applicationContext.getEnvironment().getProperty("mybatis.mapperLocations"));
        sqlSessionFactoryBean.setMapperLocations(resources);

        return sqlSessionFactoryBean;
    }

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer scannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        Properties properties = new Properties();
        properties.put("mappers", "com.service.manager.common.mapper.MyBaseMapper");
        configurer.setProperties(properties);
        configurer.setBasePackage("com.service.manager.mapper");
        return configurer;
    }
}
