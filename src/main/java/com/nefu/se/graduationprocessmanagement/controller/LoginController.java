package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("{number}/{password}")
    public User login(@PathVariable String number, @PathVariable String password){
        com.nefu.se.graduationprocessmanagement.entity.User user = loginService.loginS(number,password);
    }
}
