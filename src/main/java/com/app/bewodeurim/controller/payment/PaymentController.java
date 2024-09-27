package com.app.bewodeurim.controller.payment;

import ch.qos.logback.core.model.Model;
import com.app.bewodeurim.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/payment/*")
public class PaymentController {

    private final PaymentService paymentService;

    // 결제 처리 후 성공 페이지로 리다이렉트
    @PostMapping("/process")
    public String processPayment(@RequestParam("paymentId") String paymentId,
                                 @RequestParam("planId") Long planId,
                                 @RequestParam("memberId") Long memberId,
                                 @RequestParam("price") int price) {
        log.info("Bootpay 결제 성공 - 결제 ID: {}", paymentId);

        // 결제 정보 생성 및 저장 (TBL_PLAN에서 요금제 정보 조회)
        paymentService.processPayment(memberId, planId, price);

        // 결제 완료 후 성공 페이지로 리다이렉트
        return "redirect:/payment/payment-success";
    }

    // 결제 완료 페이지 (GET 요청)
    @GetMapping("/success")
    public String paymentSuccess() {
        return "payment/payment-success";  // payment-success 페이지로 이동
    }


}
