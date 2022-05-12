package com.community.service;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class MD5Service {
    // md5加密
    public String getMd5Password(String password, String salt) {
        /**
         * 加密规则
         * 1. 无视原密码的强度
         * 2. 使用UUID作为盐值
         * 3. 循环加密3次保证强度
         */
        for (Integer i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
