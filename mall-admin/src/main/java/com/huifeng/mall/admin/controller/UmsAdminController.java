package com.huifeng.mall.admin.controller;

import com.huifeng.mall.admin.bean.UmsAdmin;
import com.huifeng.mall.admin.service.UmsAdminService;
import com.huifeng.mall.admin.utils.CommonResult;
import com.huifeng.mall.admin.utils.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/admin")
@Api(description = "后台用户操作")
public class UmsAdminController {

    @Autowired
    UmsAdminService umsAdminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value = "用户登陆")
    public CommonResult login(HttpServletResponse response){
        //验证用户，成功生成token
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("admin");
        String token = umsAdminService.userLogin(umsAdmin);
        if(token==null){
            return new CommonResult(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null);
        }
        //将token存到cookie中
        Cookie cookie = new Cookie(tokenHeader,token);
        response.addCookie(cookie);
        return CommonResult.success(token);
    }

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户详细信息")
    public CommonResult getAdminInfo(@CookieValue("umsAdmin")String token){
        UmsAdmin umsAdmin = umsAdminService.getAdminInfo(token);
        System.out.println(token);
        return CommonResult.success(umsAdmin.getUsername());
    }

}
