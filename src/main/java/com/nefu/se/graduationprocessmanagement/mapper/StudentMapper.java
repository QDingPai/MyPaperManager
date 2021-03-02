package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.entity.Student;
import com.nefu.se.graduationprocessmanagement.vo.StudentVO;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Insert("insert into student value")
    int insertStudent(Student student);

    @Update("update `user` set role = 4 where id = #{id}")
    int updateRoleById(String id);

    @Select("select COUNT(id) from student ")
    int getStudentNum();

    @Select("select * from students")
    @Results(
            value = {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "number",property = "number"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "updata_time",property = "updataTime"),
                    @Result(column = "student",property = "student",one = @One(select = "com.nefu.se.graduationprocessmanagement.mapper.UserMapper.getUserById"))
            }
    )
    List<StudentVO> getStudents();
}