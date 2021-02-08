package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.entity.Teacher;
import com.nefu.se.graduationprocessmanagement.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from `user` where number = #{number}")
    User getUserByNumber(String number);

    @Select("select * from `user` where id = #{id}")
    User getUserById(Long id);

    int insert(User user);

    @Update("update `user` set role = 4 where id = #{id}")
    int updateRoleById(Long id);

    @Select("select * from `teacher` where id = #{uid}")
    Teacher getTeacherBuId(Long id);

    @Update("update `user` set name = #{name} where id = #{id}")
    int updateName(@Param("id")Long id,@Param("name")String name);

    @Update("update `user` set password = #{password} where id = #{id}")
    int resertPassword(@Param("id")Long id, @Param("password")String password);
}