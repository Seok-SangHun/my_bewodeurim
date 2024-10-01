package com.app.bewodeurim.service.payment;


import com.app.bewodeurim.domain.payment.PaymentDTO;
import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.domain.pickup.Pagination;
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
    public void processPayment(Long memberId, Long planId, int price) {
        // 요금제 정보 조회 (TBL_PLAN에서 가져옴)
        PlanVO selectedPlan = planService.getPlanById(planId);

        // 결제 정보 생성
        PaymentVO payment = new PaymentVO();
        payment.setMemberId(memberId);
        payment.setPlanId(planId);
        payment.setPaymentPrice(price);  // 외부에서 전달된 가격 사용
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

    @Override
    public List<PaymentDTO> getList(Pagination pagination){
        PaymentDAO paymentDTO;
        return paymentDAO.findAll(pagination);
    }

    @Override
    public int getTotal(){ return paymentDAO.getTotal(); }
}
