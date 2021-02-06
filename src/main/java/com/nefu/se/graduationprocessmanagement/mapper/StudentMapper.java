package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Insert("insert into student value") //
    int insertStudent(Student student);
    @Update("update `user` set role = 4 where id = #{id}")
    int updateRoleById(String id);
}