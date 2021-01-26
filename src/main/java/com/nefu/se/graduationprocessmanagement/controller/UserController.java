package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.component.EncryptionComponent;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.service.UserService;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ResultVO resultVO = new ResultVO();

    @PostMapping("/Login")
    public ResultVO login(@RequestBody User user){//? 可以接住 OK

        String number = user.getNumber();
        String password = user.getPassword();
        User user1 = userService.getuser(number,password);


        //设置成功
        if (user1 == null) {
            //账号或密码错误 401
            resultVO.setCode(401);
            resultVO.setMessage("账号或密码错误");
            return resultVO;
        }else {
            //成功
//
            resultVO.setMessage("登录成功");
            resultVO.setCode(200);
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("roleValue", encryptionComponent.EncryptionFor8()
                    + user1.getRoleValue()
                    + encryptionComponent.EncryptionFor8());
            resultVO.setData(map1);
            return resultVO;
        }



    }
}
