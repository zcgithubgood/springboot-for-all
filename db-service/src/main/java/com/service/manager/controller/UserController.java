package com.service.manager.controller;

import com.service.manager.bo.CmpResultCode;
import com.service.manager.bo.UserBo;
import com.service.manager.service.UserService;
import com.service.manager.vo.CmpResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Druid on 2018/4/11.
 *
 */

@RestController
@RequestMapping(value = "manager")
public class UserController {

    private UserService userService;

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "createuser", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public CmpResultVo createUser() {
        UserBo userBo = new UserBo();
        userBo.setFullName("Druid");
        userBo.setMobilePhone("13788888888");

        String id = userService.create(userBo);

        return new CmpResultVo(CmpResultCode.SUCCESS_COMMON, id, new ArrayList(), "");
    }
}
