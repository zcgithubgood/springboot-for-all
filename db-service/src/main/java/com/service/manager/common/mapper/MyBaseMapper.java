package com.service.manager.common.mapper;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Druid on 2018/4/9.
 *
 */
@Component
public interface MyBaseMapper<D> extends Mapper<D> {

}
