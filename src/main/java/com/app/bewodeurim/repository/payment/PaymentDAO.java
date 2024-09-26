package com.app.bewodeurim.repository.payment;

import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.mapper.payment.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentDAO {
    private final PaymentMapper paymentMapper;

    public void save(PaymentVO paymentVO) {
        paymentMapper.save(paymentVO);
    }
}
