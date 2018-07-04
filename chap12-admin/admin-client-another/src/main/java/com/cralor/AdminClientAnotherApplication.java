package com.cralor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class AdminClientAnotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientAnotherApplication.class, args);
    }
}
