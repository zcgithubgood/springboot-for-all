package com.service.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableAutoConfiguration
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages = {"com.service.manager.*"})
@EntityScan("com.service.manager")
@ServletComponentScan
public class DBApplication extends SpringBootServletInitializer {

	private static Logger logger = LoggerFactory.getLogger(DBApplication.class);

	public static void main(String[] args) {
		ApplicationContext application = SpringApplication.run(DBApplication.class, args);
		if (logger.isDebugEnabled()) {
			String[] beanDefinitionNames = application.getBeanDefinitionNames();
			for (String beanName : beanDefinitionNames) {
				logger.debug(beanName);
			}

		}
	}
}
