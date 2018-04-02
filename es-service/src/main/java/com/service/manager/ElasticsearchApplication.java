package com.service.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@ComponentScan(basePackages = {"com.service"})
@ServletComponentScan
public class ElasticsearchApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext application = SpringApplication.run(ElasticsearchApplication.class, args);
	}
}
