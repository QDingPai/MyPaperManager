package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.component.ResponseComponent;
import com.nefu.se.graduationprocessmanagement.dto.TeacherDTO;
import com.nefu.se.graduationprocessmanagement.mapper.TeacherMapper;
import com.nefu.se.graduationprocessmanagement.service.AdminService;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class AdminController {
    private ResultVO resultVO = new ResultVO();
    @Autowired
    private AdminService adminService;
    @Autowired
    private ResponseComponent responseComponent;
    @Autowired
    private TeacherMapper teacherMapper;

    private Map<String, Object> data = new HashMap<>();

    @PostMapping("/admin")
    public ResultVO importTeacherTable(@RequestBody List<TeacherDTO> list) {
        //事务控制???


        resultVO = responseComponent.success();
        data.put("TeacherDTO", adminService.addTeachers(list));
        resultVO.setData(data);
        return resultVO;
    }
}
