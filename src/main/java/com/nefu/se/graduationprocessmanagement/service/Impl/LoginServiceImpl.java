package com.nefu.se.graduationprocessmanagement.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import com.nefu.se.graduationprocessmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginS(String number, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("number",number);
        wrapper.eq("password",password);
        User user = userMapper.selectOne(wrapper);
        if(user == null){
            System.out.println("no");
            System.out.println(user);
            return user;
        }else{
            System.out.println("yes");
            return user;
        }
    }
}
