package com.nefu.se.graduationprocessmanagement.service;

import com.nefu.se.graduationprocessmanagement.dto.ImportTeacher;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.TeacherMapper;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
@Slf4j
@Service
public class TeacherService implements Serializable {
    private User user = new User();
    private Teacher teacher = new Teacher();
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private int i=1;
    @Transactional
    public void importImportTeacherDTO(List<ImportTeacher> list){
        log.debug("22222222222222");
        list.forEach(importTeacher -> {
            log.debug("33333333333333");
            System.out.println(importTeacher);

            user.setNumber(importTeacher.getNumber());
            user.setPassword(passwordEncoder.encode(importTeacher.getNumber()));
            user.setRoleValue(importTeacher.getRoleValue());
//            userMapper.saveUser(user);
            userMapper.insert(user);
            /**
             * 测试事务回滚
             */
//            if (importTeacher.getStudentNum()==1){
//                System.out.println(3/0);
//            }

            teacher.setTitle(importTeacher.getTitles());
            teacher.setStudentNum(importTeacher.getStudentNum());
            teacher.setName(importTeacher.getName());
            teacher.setRoleValue(importTeacher.getRoleValue());
//            teacherMapper.saveTeacher(teacher);
            teacherMapper.insert(teacher);

        });
    }
}
