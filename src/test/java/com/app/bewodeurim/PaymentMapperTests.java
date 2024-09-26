package com.app.bewodeurim;

import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.mapper.payment.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        payment.setPrice(8000);
        payment.setStatus("SUCCESS");

        // 결제 정보 삽입
        paymentMapper.save(payment);

    }

}
