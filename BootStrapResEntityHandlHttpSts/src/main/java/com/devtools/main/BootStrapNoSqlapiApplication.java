package com.devtools.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.devtools.api")  // Explicitly scan the controller package
public class BootStrapNoSqlapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootStrapNoSqlapiApplication.class, args);
    }
}
