package com.service.manager.common.util;


import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Created by Druid on 2018/4/15.
 *
 */
@Component
@Lazy(false)
public final class SpringContextUtils implements ApplicationContextAware, DisposableBean {
	/** applicationContext */
	private static ApplicationContext applicationContext;

	private SpringContextUtils() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtils.applicationContext = applicationContext;
	}

	public void destroy() throws Exception {
		applicationContext = null;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		Assert.hasText(name);
		assertContextInjected();
		return applicationContext.getBean(name);
	}

    public static Object getBean(String name, Object... var) {
        Assert.hasText(name);
        assertContextInjected();
        return applicationContext.getBean(name, var);
    }

	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);
		assertContextInjected();
		return applicationContext.getBean(name, type);
	}

    public static <T> T getBean(Class<T> type) {
        Assert.notNull(type);
        assertContextInjected();
        return applicationContext.getBean(type);
    }

    public static <T> T getBean(Class<T> type, Object... var) {
        Assert.notNull(type);
        assertContextInjected();
        return applicationContext.getBean(type, var);
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotation){
        Assert.notNull(annotation);
        assertContextInjected();
        return applicationContext.getBeansWithAnnotation(annotation);
    }

	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void assertContextInjected() {
		Validate.validState(applicationContext != null, "applicaitonContext属性未注入.");
	}

}