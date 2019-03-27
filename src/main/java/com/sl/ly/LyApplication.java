package com.sl.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.sl.ly.mapper")
@EnableScheduling
public class LyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyApplication.class, args);
    }

}
