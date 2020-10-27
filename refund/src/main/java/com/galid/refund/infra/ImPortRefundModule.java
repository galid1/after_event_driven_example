package com.galid.refund.infra;

import com.galid.refund.application.RefundModule;
import org.springframework.stereotype.Service;

@Service
public class ImPortRefundModule implements RefundModule {
    public void refund(Long orderId) {
        System.out.println(orderId + ": 환불처리 시작");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(orderId + ": 환불처리 완료");
//        throw new IllegalArgumentException("ERROR");
    }
}
