package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from `user` where number = #{number}")
    User getUserByNumber(String number);

//    @Insert("insert into `user` (number,name,role,password) values ( #{user.number} ," +
//            "#{user.name},  #{user.role} ,#{user.password})")
//    Void saveUser(@Param("user") User user);

    @Select("select * from `user` where id = #{id}")
    User getUserById(Long id);

    int insert(User user);

    @Update("update `user` set role = 4 where id = #{id}")
    int updateRoleById(String id);

    @Update("update `user` set password = #{password} where id = #{id}")
    int updatePasswordById(@Param("id") String id, @Param("password") String password);
}