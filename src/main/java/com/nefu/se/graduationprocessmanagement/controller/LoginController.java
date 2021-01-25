package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.service.LoginService;
import com.nefu.se.graduationprocessmanagement.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.web.bind.annotation.*;


import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/Login")
    public BaseResponseVO login(@RequestBody Map<String, String> user){

        String number = user.get("number");
        String password = user.get("password");
        BaseResponseVO baseResponseVO = loginService.loginS(number,password);
        return baseResponseVO;
    }
}
