package com.nefu.se.graduationprocessmanagement.component;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;


@Component
public class EncryptionComponent {
    public String EncryptionFor8(){
        byte[] array = new byte[4];
        new SecureRandom().nextBytes(array);
        char[] encode = Hex.encode(array);
        String hex = new String(encode);
        return hex;
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
