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

import java.util.List;

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

    @PostMapping("/admin")
    public ResultVO importTeacherTable(@RequestBody List<TeacherDTO> list){
    //事务控制???
//        log.debug("11111111111111");
        adminService.addTeachers(list);
        //遍历出来 dto
        //dto拆给do
        //do进行持久化
        //判断是否为空? 判断导入权限大于?
        resultVO = responseComponent.success();
//        resultVO.setData(teacherMapper.selectTeacher());
        return resultVO;
    }
}
