package com.huifeng.mall.admin.controller;

import com.huifeng.mall.admin.bean.UmsAdmin;
import com.huifeng.mall.admin.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
@Api(description = "后台用户操作")
public class UmsAdminController {

    @Autowired
    UmsAdminService umsAdminService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户登陆")
    public String login(){
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("admin");
        String token = umsAdminService.userLogin(umsAdmin);
        return token;
    }

}
