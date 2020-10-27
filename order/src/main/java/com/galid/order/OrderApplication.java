package com.galid.order;

import com.galid.order.order.application.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i ++) {
            orderService.placeOrder(Long.parseLong(String.valueOf(i)));
        }
    }
}
