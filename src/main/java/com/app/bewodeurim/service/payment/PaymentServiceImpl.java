package com.app.bewodeurim.service.payment;


import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.repository.payment.PaymentDAO;
import com.app.bewodeurim.service.plan.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO;
    private final PlanService planService;

    @Override
    public void processPayment(Long memberId, Long planId) {
        PlanVO selectedPlan = planService.getPlanById(planId);

        // 결제 정보 생성
        PaymentVO payment = new PaymentVO();
        payment.setMemberId(memberId);
        payment.setPlanId(planId);
        payment.setPaymentPrice(selectedPlan.getPrice());
        payment.setPaymentStatus("SUCCESS");

        // 결제 정보 저장
        paymentDAO.save(payment);
    }

    @Override
    public List<PaymentVO> getPaymentsByMemberId(Long memberId) {
        return paymentDAO.findPaymentsByMemberId(memberId);
    }

    @Override
    public List<PaymentVO> getAllPayments() {
        return paymentDAO.findAllPayments();
    }
}
