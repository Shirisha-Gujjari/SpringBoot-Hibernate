package com.sagarandcompany.FirstDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FirstDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstDemoApplication.class, args);
    }

}
