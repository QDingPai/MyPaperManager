package com.nefu.se.graduationprocessmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class GraduationProcessManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationProcessManagementApplication.class, args);
    }
}
