package com.myproj.myproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import({
        MybatisConfig.class
})
public class MyprojApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyprojApplication.class, args);
    }
}
