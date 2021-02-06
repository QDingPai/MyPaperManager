package com.nefu.se.graduationprocessmanagement.component;

import com.nefu.se.graduationprocessmanagement.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Map;


@Slf4j
@Component
public class EncryptionComponent {
        @Autowired
        private ObjectMapperComponent objectMapperComponent;
        private String secretKey = Constant.MY_SECRET_KEY;
        private String salt = Constant.MY_SALT;

        public String encrypt(Map payload) {
            String json = objectMapperComponent.writeValueAsString(payload);
            return Encryptors.text(secretKey, salt).encrypt(json);
        }
        public String EncryptionFor8(){
            byte[] array = new byte[4];
            new SecureRandom().nextBytes(array);
            char[] encode = Hex.encode(array);
            String hex = new String(encode);
            return hex;
    }
        public String userToJson(User user) {
            var resultMap = Map.of( "Role", user.getRole(),"Id",user.getId());
            return encrypt(resultMap);
        }
    //解决SpringScurity的BUG
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public Map<String, Object> decrypt(String encryptString) {
        try {
            String json = Encryptors.text(secretKey, salt).decrypt(encryptString);
            return objectMapperComponent.readValue(json);
        } catch (Exception e) {
            log.debug("解析错误");
        }
        return null;
    }


//    Map<String, String> map = new HashMap();
//    byte[] array = new byte[2];
//    new SecureRandom().nexBytes(array);
//    char[] encode = Hex.encode(array);
//    String hex = new String(encode);
//    byte[] array1 = new byte[2];
//    new SecureRandom().nextBytes(array1);
//    char[] encode1 = Hex.encode(array1);
//    String hex1 = new String(encode1);
//    Map<String, Object> map1 = new HashMap<String, Object>();
//    map1.put("roleValue", hex + user.getRoleValue() + hex1);
}
