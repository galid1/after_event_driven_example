package com.galid.order.order.application;

import com.galid.order.order.domain.OrderEntity;
import com.galid.order.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;

    public Long placeOrder(Long orderer) {
        OrderEntity newOrder = new OrderEntity(orderer);
        return orderRepository.save(newOrder).getOrderId();
    }

    public void cancelOrder(Long orderId) {
        // 주문 취소
        orderRepository.findById(orderId)
                .get()
                .cancel();

        // 이벤트 발행
        rabbitTemplate.convertAndSend("amq.topic", "refund.orderCancel", orderId);
    }
}
