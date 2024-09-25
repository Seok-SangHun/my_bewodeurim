package com.app.bewodeurim.mapper.inquiry;


import com.app.bewodeurim.domain.inquiry.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface InquiryMapper {
    //  1:1 문의 작성
    public void insert(InquiryVO inquiryVO);

    // 특정 회원의 1:1 문의 내역 조회
    List<InquiryVO> findByMemberId(Long memberId);
}
