package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.dto.TeacherDTO;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select("select * from `teacher` where id = #{id}")
    Teacher selectTeacher(Long id);

    int insert(Teacher teacher);

    @Update("update `teacher` set title = #{title}  where id = #{id}")
    int updateTeacherTitle(@Param("id")Long uid ,@Param("title")String title );
}