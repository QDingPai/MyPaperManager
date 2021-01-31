package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.component.EncryptionComponent;
import com.nefu.se.graduationprocessmanagement.component.ResponseComponent;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.service.UserService;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EncryptionComponent encryptionComponent;
    @Autowired
    private ResponseComponent responseComponent;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private ResultVO resultVO = new ResultVO();

    @PostMapping("/Login")
    public ResultVO login(@RequestBody User user){

        User user1 = userService.getUser(user.getNumber());
        if (user1 == null) {
        //账号或密码错误 400
            return responseComponent.requestError();
        }
        if (!passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
        //账号或密码错误 400
            System.out.println(user.getPassword()+user1.getPassword());
            return responseComponent.requestError();
        }
        //成功
        //设置header
        responseComponent.setResponseHeader(encryptionComponent.userToJson(user1));

        resultVO = responseComponent.success();
        Map<String, Object> map1 = new HashMap();
        map1.put("roleValue", encryptionComponent.EncryptionFor8()
                + user1.getRole()
                + encryptionComponent.EncryptionFor8());
        resultVO.setData(map1);
        return resultVO;




    }
}
