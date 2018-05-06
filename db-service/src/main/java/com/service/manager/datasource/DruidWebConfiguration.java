package com.service.manager.datasource;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Druid on 2017/5/6.
 *
 */
@Configuration(value ="druidWebConfiguration" )
@ConditionalOnWebApplication
public class DruidWebConfiguration {

    @Bean(name = "druidWebStatFilter")
    public FilterRegistrationBean druidWebStatFilter(DruidProperties ds){
        FilterRegistrationBean filterRegistrationBean =  new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParameters = new HashMap<String, String>(1);
        initParameters.put("exclusions" , ds.getExclusions());
        initParameters.put("sessionStatMaxCount" , ds.getSessionStatMaxCount().toString());
        initParameters.put("sessionStatEnable",String.valueOf(ds.isSessionStatEnable()));
        if(ds.getPrincipalSessionName()!=null){
            initParameters.put("principalSessionName",ds.getPrincipalSessionName());
        }
        initParameters.put("profileEnable",String.valueOf(ds.isProfileEnable()));
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

    @Bean(name = "charsetEncodingFilter")
    public FilterRegistrationBean charsetEncodingFilter(){
        FilterRegistrationBean filterRegistrationBean =  new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        filterRegistrationBean.setFilter(characterEncodingFilter);
        return filterRegistrationBean;
    }

    @Bean(name = "druid")
    public ServletRegistrationBean druid(DruidProperties ds) throws SQLException {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> map = new HashMap<String, String>();
        map.put("resetEnable",String.valueOf(ds.isResetEnable()));
        if(ds.getLoginUsername()!=null){
            map.put("loginUsername",ds.getLoginUsername());
        }
        if(ds.getLoginPassword()!=null){
            map.put("loginPassword",ds.getLoginPassword());
        }
        if(ds.getJmxUrl()!=null){
            map.put("jmxUrl",ds.getJmxUrl());
        }
        if(ds.getJmxUsername()!=null){
            map.put("jmxUsername",ds.getJmxUsername());
        }
        if(ds.getJmxPassword()!=null){
            map.put("jmxPassword",ds.getJmxPassword());
        }
        registrationBean.setInitParameters(map);
        return registrationBean;
    }

}
