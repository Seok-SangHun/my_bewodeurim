package com.app.bewodeurim.controller.payment;

import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.domain.payment.*;
import com.app.bewodeurim.service.payment.PaymentService;
import com.app.bewodeurim.service.plan.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/payment/*")
public class PaymentController {

    private final PaymentService paymentService;
    private final PlanService planService;

    @GetMapping("/payment")
    public String paymentPage(Model model) {
        // 모든 Plan 데이터를 가져옴
        List<PlanVO> plans = planService.getAllPlans();
        model.addAttribute("plans", plans); // Model에 plans를 담아 View로 전달
        return "payment/payment";
    }

    // Plan ID로 요금제 정보 조회하는 컨트롤러 메서드
    @GetMapping("/getPlanById")
    public PlanVO getPlanById(@RequestParam Long planId) {
        return planService.getPlanById(planId); // 요금제 ID로 요금제 정보 조회
    }


    // 결제 내역 페이징 처리
    @GetMapping("/payment/list")
    public void getList(Pagination pagination, Model model) {

        // 정렬 설정 (정렬 조건이 없을 경우 "recent"로 기본 설정)
        if (pagination.getOrder() == null) {
            pagination.setOrder("recent");
        }

        // 총 결제 내역 수를 가져와서 Pagination에 설정
        pagination.setTotal(paymentService.getTotal());

        // 페이징 계산 진행
        pagination.progress();

        // 결제 내역과 페이징 정보 모델에 추가
        model.addAttribute("payments", paymentService.getList(pagination));
        model.addAttribute("pagination", pagination); // 페이지네이션 정보 모델에 전달
    }



}
