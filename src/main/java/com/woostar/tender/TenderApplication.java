package com.woostar.tender;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan("com.woostar.tender.mapper")
public class TenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenderApplication.class, args);
    }
}
