package com.service.manager.common.annotation;

import java.lang.annotation.*;

/**
 * Created by Druid on 2018/4/15.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface CmpManagerService {
}
