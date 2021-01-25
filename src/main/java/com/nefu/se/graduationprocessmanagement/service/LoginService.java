package com.nefu.se.graduationprocessmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nefu.se.graduationprocessmanagement.entity.User;


public interface LoginService extends IService<User> {
    public abstract User loginS(String number, String password);
}
