package com.chenlw.practice.sceurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动一个服务注册中心，只需要一个注解@EnableEurekaServer
 */
@SpringBootApplication
@EnableEurekaServer
public class ScEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScEurekaServerApplication.class, args);
    }

}
