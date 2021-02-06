package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.entity.Student;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.exception.AuthorNotFoundExeception;
import com.nefu.se.graduationprocessmanagement.service.UserService;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/director")
public class DirectorController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/students")
    public ResultVO importStudent(@RequestBody Map<String ,Object> students) {
        //TODO 1 J
        //遍历 事务 插入
        return null;
    }
    @PatchMapping("/teachers/{uid}/role")
    public ResultVO updateTeacherRole(@PathVariable(value = "uid") String id) {
        // 判断uid指定的用户是否存在
        User user1 = Optional.ofNullable(userService.getUserById(id))
                .orElseThrow(() -> {
                    return new AuthorNotFoundExeception("用户不存在");
                });
        // 判断权限足够?
        int role = user1.getRole();
        if (role <= 2) {
            return ResultVO.NotPermit();
        }
        // 修改权限
        userService.updateRole(id);
        // 返回角色
        Map map = new HashMap();
        map.put("role",4);
        ResultVO resultVO = null;
        resultVO.success();
        resultVO.setData(map);
        return resultVO;
    }
    @PatchMapping("/teachers/{uid}/info")
    public ResultVO updateTeacherInfo(@RequestBody User user) {
        //todo 3 J
        return null;
    }
    @PutMapping("/teachers/{uid}/password")
    public ResultVO resertTeacherPassword(@PathVariable(value = "uid") String id) {
        // 判断uid指定的用户是否存在
        User user1 = Optional.ofNullable(userService.getUserById(id))
                .orElseThrow(() -> {
                    return new AuthorNotFoundExeception("用户不存在");
                });
        // 判断权限足够?
        int role = user1.getRole();
        if (role <= 2) {
            return ResultVO.NotPermit();
        }
        //重置密码
        String newPassword = passwordEncoder.encode(user1.getNumber());
        userService.resertPasswordById(id, newPassword);
        ResultVO resultVO = null;
        resultVO.success();
//        resultVO.setData(map);
        return resultVO;
    }

}
