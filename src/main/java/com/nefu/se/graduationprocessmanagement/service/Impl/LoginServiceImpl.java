package com.nefu.se.graduationprocessmanagement.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nefu.se.graduationprocessmanagement.component.ResponseUtil;
import com.nefu.se.graduationprocessmanagement.entity.User;
import com.nefu.se.graduationprocessmanagement.mapper.UserMapper;
import com.nefu.se.graduationprocessmanagement.service.LoginService;
import com.nefu.se.graduationprocessmanagement.vo.BaseResponseVO;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO loginS(String number, String password) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("number",number);
        wrapper.eq("password",password);
        User user = userMapper.selectOne(wrapper);

        if(user == null){
            //账号或密码错误 401
            ResultVO resultVO=new ResultVO();
            resultVO.setCode(401);
            resultVO.setMessage("账号或密码错误");
            return resultVO;
        }else{
            //成功
            Map<String,String> map = new HashMap();
            byte[] array = new byte[4];
            new SecureRandom().nextBytes(array);
            char[] encode = Hex.encode(array);
            String hex = new String(encode);
            byte[] array1 = new byte[3];
            new SecureRandom().nextBytes(array1);
            char[] encode1 = Hex.encode(array1);
            String hex1 = new String(encode1);
            ResultVO resultVO=new ResultVO();
            resultVO.setMessage(encode+user.getNumber()+encode1);
            resultVO.setCode(200);
            Map<String,Object> map1=new HashMap<String,Object>();
            map1.put("roleValue",hex+user.getRoleValue()+hex1);
            resultVO.setData(map1);
            return resultVO;
        }
    }
}
