package com.nefu.se.graduationprocessmanagement.controller;

import com.nefu.se.graduationprocessmanagement.dto.ImportTeacher;
import com.nefu.se.graduationprocessmanagement.service.TeacherService;
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
public class TeacherController {
    private ResultVO resultVO = new ResultVO();
    @Autowired
    private TeacherService teacherService;


    @PostMapping("/admin")
    public ResultVO importTeacherTable(@RequestBody List<ImportTeacher> list){
    //事务控制???
//        log.debug("11111111111111");
        teacherService.importImportTeacherDTO(list);
        //遍历出来 dto
        //dto拆给do
        //do进行持久化
        //判断是否为空? 判断导入权限大于?
        return resultVO;
    }
}
