package com.service.manager.common.service;

import com.service.manager.common.annotation.CmpManagerService;
import com.service.manager.common.bo.BaseBo;
import com.service.manager.common.exception.InterruptException;
import com.service.manager.common.mapper.MyBaseMapper;
import com.service.manager.common.util.GenricTypeUtil;
import com.service.manager.common.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * Created by Druid on 2018/4/11.
 *
 */
@CmpManagerService
public abstract class BaseService<D, B extends BaseBo> {

    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    protected abstract String getIdPrefix();

    private final static String DEFAULT_IDPREFIX = "ent";

    private final static String ID_SEPARATOR = "-";

    @Autowired
    protected MyBaseMapper<D> myMapper;

    protected Class<D> doClass = GenricTypeUtil.getSuperClassGenricType(this.getClass(), 0);

    public String create(B bo){
        String id = bo.getId();
        if(StringUtils.isEmpty(id)) {
            bo.setId(createUuid());
        }
        D doObj = (D)newInstance(doClass);
        BeanUtils.copyProperties(bo, doObj);

        int ret = myMapper.insertSelective(doObj);
        return bo.getId();
    }

    protected Object newInstance(Class clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            logger.error("New InstanceBo object error!", e);
            throw new InterruptException("1", "服务器异常", e);
        } catch (IllegalAccessException e) {
            logger.error("New InstanceBo object error!", e);
            throw new InterruptException("1", "服务器异常", e);
        }
    }

    public String createUuid(){
        String idPrefix = getIdPrefix();
        if(StringUtils.isEmpty(idPrefix)){
            idPrefix = DEFAULT_IDPREFIX;
        }
        return idPrefix + ID_SEPARATOR + UuidUtil.encode();
    }
}
