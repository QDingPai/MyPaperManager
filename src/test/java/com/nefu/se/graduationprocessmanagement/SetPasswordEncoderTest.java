package com.nefu.se.graduationprocessmanagement;

import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SetPasswordEncoderTest {
    @Autowired
    public UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void testInsert(){
        User user = new User();
        user.setNumber("1001");
        user.setName("hhh");
        var password = "123456";
        String rePassword = passwordEncoder.encode(password);
        System.out.println(rePassword);
        user.setPassword(rePassword);
        user.setRole(1);

        int result = userMapper.insert(user);

        System.out.println(result); // 受影响的行数
        System.out.println(user); // 发现，id会自动回填
    }
}
