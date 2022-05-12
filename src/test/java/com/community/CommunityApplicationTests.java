package com.community;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
        String salt = "123456";
        String password = "123456";
        for (Integer i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        System.out.println(password);
    }

}
