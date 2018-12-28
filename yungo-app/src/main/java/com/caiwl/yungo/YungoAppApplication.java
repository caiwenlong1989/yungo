package com.caiwl.yungo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.caiwl.yungo.mapper")
public class YungoAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(YungoAppApplication.class, args);
    }
}
