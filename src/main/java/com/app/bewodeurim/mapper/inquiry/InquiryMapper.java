package com.app.bewodeurim.mapper.inquiry;


import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface InquiryMapper {
    //  1:1 문의 작성
    public void insert(InquiryVO inquiryVO);

    // 1:1 문의 등록
    public void insertInquiry(InquiryDTO inquiryDTO);

    // 특정 회원의 상담 내역을 조회
    public List<InquiryDTO> selectByMemberId(@Param("memberId") Long memberId, @Param("pagination") Pagination pagination);

    // 문의 목록 전체 개수 조회
    public int selectTotal();

    // 모든 상담 목록 조회 (추가된 메서드)
    public List<InquiryDTO> selectAllInquiries();
}
