package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.domain.pickup.Pagination;

import java.util.List;


public interface InquiryService {
    // 1:1 문의 목록 작성
    public void write(InquiryVO inquiryVO);

    // 1:1 문의 등록
    public void registerInquiry(InquiryDTO inquiryDTO);

    // 특정 회원의 상담 목록 조회
    public List<InquiryDTO> getListByMemberId(Long memberId, Pagination pagination);

    // 목록 전체 개수 조회
    public int getTotal();

    // 특정 회원의 전체 문의 수 조회
    public int getTotalByMemberId(Long memberId);

    // 전체 상담 목록 조회 (추가된 메서드)
    public List<InquiryDTO> getAllInquiries();
//    // 특정 회원의 상담 내역 조회
//    List<InquiryVO> getInquiriesByMemberId(Long memberId);
}
