package com.service.manager.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Druid on 2018/4/11.
 * 泛型类型获取工具
 */
public class GenricTypeUtil {

    public static Class getSuperClassGenricType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if(!(genType instanceof ParameterizedType)) {
            return Object.class;
        } else {
            Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
            if(index < params.length && index >= 0) {
                return !(params[index] instanceof Class)?Object.class:(Class)params[index];
            } else {
                throw new RuntimeException("你输入的索引" + (index < 0?"不能小于0":"超出了参数的总数"));
            }
        }
    }
}
