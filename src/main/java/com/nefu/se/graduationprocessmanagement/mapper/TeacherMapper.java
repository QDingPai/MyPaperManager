package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.dto.TeacherDTO;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import com.nefu.se.graduationprocessmanagement.vo.TeacherVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select("select * from `teacher` where id = #{id}")
    Teacher selectTeacher(Long id);

    int insert(Teacher teacher);

    @Update("update `teacher` set title = #{title}  where id = #{id}")
    int updateTeacherTitle(@Param("id") Long uid, @Param("title") String title);

    @Select("select user.id,teacher.title,user.name,teacher.description,teacher.group,teacher.quantity,user.update_time" +
            " from user,teacher " +
            "where user.id = teacher.id")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description"),
            @Result(column = "group", property = "group"),
            @Result(column = "quantity", property = "quantity"),
            @Result(column = "update_time", property = "updateTime")
    }
    )
    List<TeacherVO> getAllTeachers();
}