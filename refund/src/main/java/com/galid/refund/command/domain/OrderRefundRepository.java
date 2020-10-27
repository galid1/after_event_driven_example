package com.galid.refund.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRefundRepository extends JpaRepository<OrderRefundEntity, Long> {
}
