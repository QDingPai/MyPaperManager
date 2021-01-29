package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Insert("insert into `teacher` values " +
            "( #{teacher.id}, #{teacher.title} " +
            ", #{teacher.studentNum} , #{teacher.roleValue}" +
            ", #{teacher.description}, #{teacher.name})")
     Void saveTeacher(Teacher teacher);

    int insert(Teacher teacher);
}