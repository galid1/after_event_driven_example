package com.galid.refund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RefundApplication {
    public static void main(String[] args) {
        SpringApplication.run(RefundApplication.class, args);
    }
}
