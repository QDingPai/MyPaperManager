package com.nefu.se.graduationprocessmanagement.service;

import com.nefu.se.graduationprocessmanagement.dto.TeacherDTO;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.TeacherMapper;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
@Transactional
public class AdminService {
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

    public void addTeachers(List<TeacherDTO> list){
        list.forEach(teacherDTO -> {
            System.out.println(teacherDTO);
            user.setNumber(teacherDTO.getNumber());
            user.setName(teacherDTO.getName());
            user.setPassword(passwordEncoder.encode(teacherDTO.getNumber()));
            if (teacherDTO.getRole() == null){
                user.setRole(2);
            }else {
                user.setRole(teacherDTO.getRole());
            }


//            userMapper.saveUser(user);
            userMapper.insert(user);
            /**
             * 测试事务回滚
             */
//            if (teacherDTO.getQuantity()==1){
//                System.out.println(3/0);
//            }

            teacher.setId(user.getId());
            if (teacherDTO.getTitles() == null){
                teacher.setTitle("讲师");
            }else {
                teacher.setTitle(teacherDTO.getTitles());
            }

            if (teacherDTO.getQuantity() == null){
                teacher.setQuantity(7);
            }else {
                teacher.setQuantity(teacherDTO.getQuantity());
            }
            //group

//                teacher.setGroup((short)1); //??

            //description

                teacher.setDescription("Web相关");

//            teacherMapper.saveTeacher(teacher);
            teacherMapper.insert(teacher);

        });
    }
}
