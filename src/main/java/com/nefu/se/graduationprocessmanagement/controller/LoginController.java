package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/Login")
    public User login(@RequestBody Map<String, String> user){
        String number = user.get("number");
        String password = user.get("password");

        User usert = loginService.loginS(number,password);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("userLogin");
//        modelAndView.addObject("user",user);
        return usert;
    }
}
