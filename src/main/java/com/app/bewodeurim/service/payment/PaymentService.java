package com.app.bewodeurim.service.payment;

import com.app.bewodeurim.domain.payment.PaymentVO;

import java.util.List;

public interface PaymentService {
    public void processPayment(Long MemberId, Long PlanId);

    List<PaymentVO> getPaymentsByMemberId(Long memberId);

    List<PaymentVO> getAllPayments();


}
