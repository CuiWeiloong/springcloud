package com.cralor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot3ApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("test23!");
        BCryptPasswordEncoder util = new BCryptPasswordEncoder();
        for(int i = 0 ; i < 10; i ++){
            System. out.println("经hash后的密码为："+util.encode("123" ));
        }
    }

}
