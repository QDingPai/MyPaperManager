package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("Login/{number}/{password}")
    public @ResponseBody User login(@PathVariable String number, @PathVariable String password){
        User user = loginService.loginS(number,password);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("userLogin");
//        modelAndView.addObject("user",user);
        return user;
    }
}
