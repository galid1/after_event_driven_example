package com.galid.order.order.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {
    @Id @GeneratedValue
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Long orderer;

    @Builder
    public OrderEntity(Long orderer) {
        this.orderStatus = OrderStatus.ORDERED;
        this.orderer = orderer;
    }

    public void cancel() {
        verifyCouldCancel();
        this.orderStatus = OrderStatus.CANCEL;
    }

    private void verifyCouldCancel() {
        if (orderStatus != OrderStatus.ORDERED)
            throw new IllegalStateException("배송 시작후, 주문 취소가 불가능합니다.");
    }

    public void ship() {
        // 배송 시작 로직 ~
    }
}
