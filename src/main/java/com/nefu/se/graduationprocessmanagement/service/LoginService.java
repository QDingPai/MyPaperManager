package com.nefu.se.graduationprocessmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.vo.BaseResponseVO;


public interface LoginService extends IService<User> {
    public abstract BaseResponseVO loginS(String number, String password);
}
