package com.app.bewodeurim.repository.payment;

import com.app.bewodeurim.domain.payment.PaymentDTO;
import com.app.bewodeurim.domain.payment.PaymentVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.mapper.payment.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentDAO {
    private final PaymentMapper paymentMapper;

    public void save(PaymentVO paymentVO) {
        paymentMapper.save(paymentVO);
    }

    public List<PaymentVO> findPaymentsByMemberId(Long memberId) {
        return paymentMapper.findPaymentsByMemberId(memberId);
    }

    public List<PaymentVO> findAllPayments() {
        return paymentMapper.findAllPayments();
    }

    public List<PaymentDTO> findAll(Pagination pagination){
        return paymentMapper.selectAll(pagination);
    }

//    전체 결제 내역 개수 조회
    public int getTotal(){
        return paymentMapper.selectTotal();
    }
}

