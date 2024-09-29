package com.app.bewodeurim.controller.payment;

import com.app.bewodeurim.domain.plan.PlanVO;
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

    private final PlanService planService;

    @GetMapping("/payment")
    public String paymentPage(Model model) {
        // 모든 Plan 데이터를 가져옴
        List<PlanVO> plans = planService.getAllPlans();
        model.addAttribute("plans", plans); // Model에 plans를 담아 View로 전달
        return "payment/payment"; // 기존의 payment.html을 사용
    }

    // Plan ID로 요금제 정보 조회하는 컨트롤러 메서드
    @GetMapping("/getPlanById")
    public PlanVO getPlanById(@RequestParam Long planId) {
        return planService.getPlanById(planId); // 요금제 ID로 요금제 정보 조회
    }
}
