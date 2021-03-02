package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.dto.TeacherDTO;
import com.nefu.se.graduationprocessmanagement.entity.Student;
import com.nefu.se.graduationprocessmanagement.entity.Task;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.exception.AuthorNotFoundExeception;
import com.nefu.se.graduationprocessmanagement.mapper.TaskMapper;
import com.nefu.se.graduationprocessmanagement.service.UserService;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/director")
public class DirectorController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TaskMapper taskMapper;


    @PostMapping("/students")
    public ResultVO importStudent(@RequestBody List<Student> students) {

        //遍历 事务 插入

        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @PatchMapping("/teachers/{uid}/role")
    public ResultVO updateTeacherRole(@PathVariable(value = "uid") Long id) {
        // 判断uid指定的用户是否存在
        User user1 = Optional.ofNullable(userService.getUserById(id))
                .orElseThrow(() -> {
                    return new AuthorNotFoundExeception("用户不存在");
                });
        // 判断权限足够
        int role = user1.getRole();
        if (role <= 2) {
            return ResultVO.NotPermit();
        }
        // 修改权限
        userService.updateRole(id);
        // 返回角色
        Map map = new HashMap();
        map.put("role",4);
        ResultVO resultVO = new ResultVO();
        resultVO.success();
        resultVO.setData(map);
        return resultVO;
    }

    /**
     *
     * @param uid
     * @param
     * @return
     */
    @PatchMapping("/teachers/{uid}/info")
    public ResultVO updateTeacherInfo(@PathVariable Long uid , @RequestBody TeacherDTO teacherDTO) {
        //判断uid指定的用户是否存在
        User user1 = Optional.ofNullable(userService.getUserById(uid))
                .orElseThrow(() -> {
                    return new AuthorNotFoundExeception("用户不存在");
                });
        // 判断权限足够?
        int role = user1.getRole();
        if (role <= 2) {
            return ResultVO.NotPermit();
        }
        //修改信息
        userService.updataTeacher(uid,teacherDTO.getTitle(),teacherDTO.getName());
        //返回
        Map map = new HashMap();
        map.put("title",teacherDTO.getTitle());
        map.put("name",teacherDTO.getName());
        ResultVO resultVO = new ResultVO();
        resultVO.success();
        resultVO.setData(map);
        return resultVO;


    }

    /**
     *
     *
     * @param id
     * @return
     */
    @PutMapping("/teachers/{uid}/password")
    public ResultVO resertTeacherPassword(@PathVariable(value = "uid") Long id) {
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
        //返回结果
        Map map = new HashMap();

        ResultVO resultVO = new ResultVO();
        resultVO.success();

        return resultVO;
    }

    //创建选导师任务 TODO 0 接口 时间处理有问题?
    @PostMapping("/tasks/choice")
    public ResultVO createTask(Task task) {
        taskMapper.insert(task);
        ResultVO resultVO = new ResultVO();
        resultVO.success();
        return resultVO;
    }
}


