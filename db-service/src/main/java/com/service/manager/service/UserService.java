package com.service.manager.service;

import com.service.manager.bo.UserBo;
import com.service.manager.common.service.BaseService;
import com.service.manager.mydo.user.EUser;
import org.springframework.stereotype.Service;

/**
 * Created by Druid on 2018/4/11.
 *
 */

@Service
public class UserService<D, B extends UserBo> extends BaseService<EUser, UserBo> {

    @Override
    protected String getIdPrefix() {
        return "usr";
    }
}
