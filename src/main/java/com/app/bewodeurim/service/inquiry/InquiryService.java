package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.domain.pickup.Pagination;

import java.util.List;


public interface InquiryService {
    // 1:1 문의 목록 작성
    public void write(InquiryVO inquiryVO);

    // 나의 상담 목록
    public List<InquiryDTO> getList(Pagination pagination);

    // 목록 전체 개수 조회
    public int getTotal();
//    // 특정 회원의 상담 내역 조회
//    List<InquiryVO> getInquiriesByMemberId(Long memberId);
}
