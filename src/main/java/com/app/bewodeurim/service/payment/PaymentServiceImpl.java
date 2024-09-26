package com.app.bewodeurim.service.payment;


import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.repository.payment.PaymentDAO;
import com.app.bewodeurim.service.plan.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO;
    private final PlanService planService;

    @Override
    public void processPayment(Long memberId, Long planId) {
        PlanVO selectedPlan = planService.getPlanById(planId);
    }
}
