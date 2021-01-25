package com.nefu.se.graduationprocessmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.vo.BaseResponseVO;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;


public interface LoginService extends IService<User> {
    public abstract ResultVO loginS(String number, String password);
}
