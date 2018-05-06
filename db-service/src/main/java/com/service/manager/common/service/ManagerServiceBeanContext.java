package com.service.manager.common.service;


import com.service.manager.common.annotation.CmpManagerService;
import com.service.manager.common.util.GenricTypeUtil;
import com.service.manager.common.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Druid on 2018/4/15.
 *
 */
public class ManagerServiceBeanContext {

    private static Logger logger = LoggerFactory.getLogger(ManagerServiceBeanContext.class);

    private static Map<Class, BaseService> serviceMap = new HashMap<>();

    public static void init(){
        Map<String, Object> beanMap = SpringContextUtils.getApplicationContext().getBeansWithAnnotation(CmpManagerService.class);

        for(Object service : beanMap.values()){
            Class clazz = GenricTypeUtil.getSuperClassGenricType(service.getClass(), 1);
            logger.info(service.getClass() + "=====" + clazz.getName() + "========");
            if(clazz.equals(Object.class)){
                continue;
            }

            if(service instanceof BaseService){
                serviceMap.put(clazz, (BaseService)service);
            }
        }
    }

    public static BaseService getManagerService(Class clazz){
        return serviceMap.get(clazz);
    }
}
