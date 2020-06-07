package com.myhexin.tokenverification;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.myhexin.tokenverification.mapper")
public class TokenVerificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenVerificationApplication.class, args);
    }

}
