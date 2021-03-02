package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.component.ObjectMapperComponent;
import com.nefu.se.graduationprocessmanagement.component.RequestComponent;
import com.nefu.se.graduationprocessmanagement.mapper.StudentMapper;
import com.nefu.se.graduationprocessmanagement.mapper.TeacherMapper;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/common")
public class CommonController {
    @Autowired
    private ObjectMapperComponent objectMapperComponent;
    @Autowired
    private RequestComponent requestComponent;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;




    //获取所有教师信息
    @GetMapping("/teachers")
    public ResultVO getAllTeacherInfo() {
        ResultVO resultVO = new ResultVO();
        resultVO.success();
        Map<String,Object> map = new HashMap<>();
        map.put("teachers",teacherMapper.getAllTeachers());
        //测试通过但是 无法返回
        resultVO.setData(map);
//        resultVO.setData(Map.of("teachers",teacherMapper.getAllTeachers()));
        return resultVO;
    }
    //获取全部学生的基本信息
    @GetMapping("/students")
    public ResultVO getAllStudents(){
        ResultVO resultVO = new ResultVO();
        resultVO.success();
        Map<String,Object> map = new HashMap<>();
        map.put("students",teacherMapper.getAllTeachers());
        resultVO.setData(map);
        return resultVO;
    }
    //所有用户修改个人密码。 TODO 0   忽略token 未测试
    @PatchMapping("/password")
    public ResultVO updatePassword(String password) {
        Long id = (Long) objectMapperComponent.readValue
                (requestComponent.getCurrentRequest()
                        .getHeader("Authorization")).get("Id");
        String rePassword = passwordEncoder.encode(password);
        userMapper.updatePassword(id, rePassword);
        ResultVO resultVO = new ResultVO();
        resultVO.success();
//        resultVO.setData();
        return resultVO;

    }
    @GetMapping("/students/count")
    public int countStudent(){
        int count = 0;
        count = studentMapper.getStudentNum();
        return count;
    }

}
