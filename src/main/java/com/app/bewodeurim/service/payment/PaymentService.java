package com.app.bewodeurim.service.payment;

import com.app.bewodeurim.domain.payment.PaymentVO;

import java.util.List;

public interface PaymentService {
    void processPayment(Long memberId, Long planId, int price); // 가격을 포함하여 처리

    List<PaymentVO> getPaymentsByMemberId(Long memberId);

    List<PaymentVO> getAllPayments();
}
