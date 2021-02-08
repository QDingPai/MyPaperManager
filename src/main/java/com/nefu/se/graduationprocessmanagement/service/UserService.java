package com.nefu.se.graduationprocessmanagement.service;

import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.TeacherMapper;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;

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

    public User getUserById(Long number) {
        return userMapper.getUserById(number);
    }
    public Integer updateRole(Long id){
        userMapper.updateRoleById(id);
        return null;
    }
    //todo 完善
    public void resertPasswordById(Long id, String password){
        userMapper.resertPassword(id, password);
    }
    public void updataTeacher(Long uid, String title,String name ){
        userMapper.updateName(uid,name);
        teacherMapper.updateTeacherTitle(uid,title);
    }
}
