package com.neuqsoft.demo;

import com.neuqsoft.commons.spring.exception.handler.EnableGlobalException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableGlobalException
@SpringBootApplication
public class HrManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagerApplication.class, args);
    }

}
