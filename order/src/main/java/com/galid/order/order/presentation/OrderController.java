package com.galid.order.order.presentation;

import com.galid.order.order.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders/users/{userId}")
    public Long placeOrder(@PathVariable("userId") Long userId) {
        return orderService.placeOrder(userId);
    }

    @PutMapping("/orders/{orderId}")
    public void cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
    }
}
