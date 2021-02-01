package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.dto.TeacherDTO;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Insert("insert into `teacher` (id,group,title,quantity,description) values " +
            "( #{teacher.id}, #{teacher.group}, #{teacher.title} " +
            ", #{teacher.quantity}" +
            ", #{teacher.description})")
     Void saveTeacher(@Param("teacher") Teacher teacher);

    @Select("select * from `teacher` where id = #{id}")
    Teacher selectTeacher(/*@Param("teacher")*/ Long id);

    int insert(Teacher teacher);
}