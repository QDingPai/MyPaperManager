package com.nefu.se.graduationprocessmanagement.controller;


import com.nefu.se.graduationprocessmanagement.component.ObjectMapperComponent;
import com.nefu.se.graduationprocessmanagement.component.RequestComponent;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import com.nefu.se.graduationprocessmanagement.mapper.TeacherMapper;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private RequestComponent requestComponent;
    @Autowired
    private ObjectMapperComponent objectMapperComponent;
    @Autowired
    TeacherMapper teacherMapper;
    @PatchMapping("/teachers/info")
    //TODO 0 未测试 忽略token
    public ResultVO getTeacherInfo() {
        //从Token获取id
        Long id = (Long) objectMapperComponent.readValue
                        (requestComponent.getCurrentRequest()
                                .getHeader("Authorization")).get("Id");
        Teacher teacher =teacherMapper.selectTeacher(id);
        ResultVO resultVO = new ResultVO();
        resultVO.success();
        resultVO.setData(Map.of("title",teacher.getTitle(),
                "description",teacher.getDescription()));
        return resultVO;
    }

}
