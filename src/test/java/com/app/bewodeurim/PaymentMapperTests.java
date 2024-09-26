package com.app.bewodeurim;

import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.mapper.payment.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class PaymentMapperTests {
    @Autowired
    public PaymentMapper paymentMapper;

    @Test
    public void testInsertPayment() {
        PaymentVO payment = new PaymentVO();
        payment.setMemberId(21L);
        payment.setPlanId(41L);
        payment.setPaymentPrice(8000);
        payment.setPaymentStatus("SUCCESS");


        paymentMapper.save(payment);

    }

    @Test
    public void testFindPaymentsByMemberId() {
        Long memberId = 21L;
        List<PaymentVO> payments = paymentMapper.findPaymentsByMemberId(memberId);

        for (PaymentVO payment : payments) {
            log.info("결제 ID: " + payment.getId());
            log.info("결제 금액: " + payment.getPaymentPrice());
            log.info("결제 상태: " + payment.getPaymentStatus());
        }

    }


    @Test
    public void testFindPayments(){
        List<PaymentVO> payments = paymentMapper.findAllPayments();

        log.info(payments.toString());
    }
}



