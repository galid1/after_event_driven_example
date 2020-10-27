package com.galid.refund.application;

import com.galid.refund.command.domain.OrderRefundEntity;
import com.galid.refund.command.domain.OrderRefundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RefundService {
    private final OrderRefundRepository orderRefundRepository;
    private final RefundModule refundModule;
    private final RabbitTemplate rabbitTemplate;

    @Async
    @RabbitListener(queues = "refund.queue")
    public void startRefund(Long orderId) {
        OrderRefundEntity refundEntity = new OrderRefundEntity(orderId);
        orderRefundRepository.save(refundEntity);
        refundModule.refund(orderId);

        // 환불 완료 상태로 변경
        refundEntity.refundComplete();

        // 환불 완료 이벤트 발송
        rabbitTemplate.convertAndSend("amq.topic", "mail.queue", "mail");
    }
}
