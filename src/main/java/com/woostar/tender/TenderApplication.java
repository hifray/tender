package com.woostar.tender;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class TenderApplication
 *
 * @author huangshuo
 * Created on 2018-06-01
 */
@SpringBootApplication
@ComponentScan
@MapperScan("com.woostar.tender.mapper")
public class TenderApplication {

    /**
     * Method main
     *
     * @param args of type String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(TenderApplication.class, args);
    }
}
