package com.galid.refund.command.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class OrderRefundEntity {
    @Id @GeneratedValue
    private Long OrderRefundId;

    private Long orderId;
    private RefundStatus refundStatus;

    @Builder
    public OrderRefundEntity(Long orderId) {
        this.orderId = orderId;
        this.refundStatus = RefundStatus.REFUND_STARTED;
    }

    public void refundComplete() {
        this.refundStatus = RefundStatus.REFUND_COMPLETE;
    }
}
