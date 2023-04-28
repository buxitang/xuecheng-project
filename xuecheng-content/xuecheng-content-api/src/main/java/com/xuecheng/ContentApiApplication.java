package com.xuecheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableSwagger2Doc
@SpringBootApplication
public class ContentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentApiApplication.class, args);
    }

}
