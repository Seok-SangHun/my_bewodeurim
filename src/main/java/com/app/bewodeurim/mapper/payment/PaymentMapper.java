package com.app.bewodeurim.mapper.payment;

import com.app.bewodeurim.domain.payment.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    void save(PaymentVO paymentVO);  // 결제 정보 저장

    List<PaymentVO> findPaymentsByMemberId(Long memberId); // 특정 회원 결제 정보 조회

    List<PaymentVO> findAllPayments(); // 전체 결제 정보 조회


}
