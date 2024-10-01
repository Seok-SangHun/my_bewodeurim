package com.app.bewodeurim.mapper.payment;

import com.app.bewodeurim.domain.payment.PaymentDTO;
import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {
    void save(PaymentVO paymentVO);  // 결제 정보 저장

    public List<PaymentVO> findPaymentsByMemberId(Long memberId); // 특정 회원 결제 정보 조회
    public List<PaymentDTO> selectAll(@Param("pagination") Pagination pagination);
    List<PaymentVO> findAllPayments(); // 전체 결제 정보 조회
//    전체 결제 내역 개수 조회
    public int selectTotal();



}
