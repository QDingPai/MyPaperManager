package com.nefu.se.graduationprocessmanagement;

import com.nefu.se.graduationprocessmanagement.dto.TeacherDTO;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.TeacherMapper;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
class GraduationProcessManagementApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;

//    @Autowired
//    private UserMapper userMapper;
//    @Test
//    public void add_test() {
//        User user = new User();
//        user.setName("SUN");
//        userMapper.insert(user);
//    }
//
//    @Test
//    void contextLoads() {
//        User u = userMapper.selectById(1350850072954339329L);
//        u.setAddress("114");
//        userMapper.updateById(u);
//    }
    @Test
    public void teacherDTO(){
        User user = userMapper.getUserById(1001L);
//        System.out.println(userMapper.getUserById(1001L));
        Teacher teacher = teacherMapper.selectTeacher(1001L);
//        System.out.println(teacherMapper.selectTeacher(1001L));
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setName(user.getName());
        teacherDTO.setQuantity(teacher.getQuantity());
        teacherDTO.setRole(user.getRole());
        teacherDTO.setNumber(user.getNumber());
        teacherDTO.setTitle(teacher.getTitle());
        System.out.println(teacherDTO);
        // TODO 完成记得测试
    }
}
