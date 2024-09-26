package com.app.bewodeurim.mapper.payment;

import com.app.bewodeurim.domain.payment.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    void save(PaymentVO paymentVO);
}

