package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryVO;

public interface InquiryService {
    // 1:1 문의 목록 작성
    public void completeInquiry(InquiryVO inquiryVO);
}
