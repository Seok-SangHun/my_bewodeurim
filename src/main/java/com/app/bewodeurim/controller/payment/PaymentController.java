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

    @GetMapping("/form")
    public void paymentForm(){
        log.info("결제 페이지로 이동");
    }

    @PostMapping("/process")
    public String processPayment(@RequestParam("memberId") Long memberId,
                                 @RequestParam("planId") Long planId) {
        log.info("결제 처리 시작 - 회원 ID: {}, 요금제 ID: {}", memberId, planId);

//        결제 처리 로직 호출
        paymentService.processPayment(memberId, planId);

        return "redirect:/payment/form";


    }

    @GetMapping("/success")
    public void paymentSuccess(){
        log.info("결제 성공 페이지로 이동");
    }

}
