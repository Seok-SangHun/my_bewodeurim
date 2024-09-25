package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryVO;

import java.util.List;


public interface InquiryService {
    // 1:1 문의 목록 작성
    public void completeInquiry(InquiryVO inquiryVO);

    // 특정 회원의 상담 내역 조회
    List<InquiryVO> getInquiriesByMemberId(Long memberId);
}
