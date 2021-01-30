package com.huifeng.mall.admin.service;

import com.huifeng.mall.admin.bean.UmsAdmin;

public interface UmsAdminService {
    //根据用户登陆信息生成token返回
    String userLogin(UmsAdmin umsAdmin);
    //通过用户名获取用户信息
    UmsAdmin getUmsAdminByUserName(String userName);
}
