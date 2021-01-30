package com.huifeng.mall.admin.service.impl;

import com.huifeng.mall.admin.bean.UmsAdmin;
import com.huifeng.mall.admin.mapper.UmsAdminMapper;
import com.huifeng.mall.admin.service.UmsAdminService;
import com.huifeng.mall.admin.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    UmsAdminMapper umsAdminMapper;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public String userLogin(UmsAdmin umsAdmin) {
        String token=null;
        UmsAdmin ums = getUmsAdminByUserName(umsAdmin.getUsername());
        if(ums==null){
            return null;
        }
        Map<String, Object> map = new HashMap();
        map.put("UmsAdmin",ums);
        token = jwtTokenUtil.createToken(map,"zy");
        return token;
    }

    @Override
    public UmsAdmin getUmsAdminByUserName(String userName) {
        //先查询缓存
        //再查询数据库
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername(userName);
        UmsAdmin ums = umsAdminMapper.selectOne(umsAdmin);
        if(ums!=null){
            return ums;
        }
        return null;
    }
}
