package com.app.bewodeurim.service.payment;


import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.repository.payment.PaymentDAO;
import com.app.bewodeurim.service.plan.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO;
    private final PlanService planService;

    @Override
    public void processPayment(Long memberId, Long planId) {
        // 요금제 정보 조회
        PlanVO selectedPlan = planService.getPlanById(planId);

        // 결제 정보 생성
        PaymentVO payment = new PaymentVO();
        payment.setMemberId(memberId);  // 로그인된 사용자 ID
        payment.setPlanId(planId);      // 선택된 요금제 ID
        payment.setPrice(selectedPlan.getPrice());  // PLAN_PRICE 값을 PAYMENT_PRICE로 설정
        payment.setStatus("SUCCESS");   // 결제 상태

        // 결제 정보 저장
        paymentDAO.save(payment);
    }

    @Override
    public void PaymentView(Long PaymentId){

    }
}
