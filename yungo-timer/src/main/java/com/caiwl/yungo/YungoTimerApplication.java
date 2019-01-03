package com.caiwl.yungo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.caiwl.yungo.mapper")
public class YungoTimerApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(YungoTimerApplication.class);
        app.setWebEnvironment(false);
        app.run(args);
    }
}
