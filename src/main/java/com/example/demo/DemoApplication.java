package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * File Header
 * PROJECT_NAME: ws-demo
 * PACKAGE_NAME: com.example.demo
 *
 * @author Kyou 2017/12/23 16:57
 */
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
