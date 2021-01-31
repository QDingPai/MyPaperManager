package com.nefu.se.graduationprocessmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nefu.se.graduationprocessmanagement.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from `user` where number = #{number}")
    User getUserByNumber(String number);
    @Insert("insert into `user` (number,name,role,password) values ( #{user.number} ," +
            "#{user.name},  #{user.role} ,#{user.password})")
    Void saveUser(@Param("user") User user);

    int insert(User user);
}