package com.nefu.se.graduationprocessmanagement.service;

import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(String number) {
        //改为原SQL
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("number", number);
//        wrapper.eq("password", password);
        /*
        Map<String, Object> map = new HashMap();
        map.put("number",number);
        map.put("password",password);
        List<User> list = userMapper.selectByMap(map);
        User user = list.get(0);

        */
        return userMapper.getUserByNumber(number);
        }
}

