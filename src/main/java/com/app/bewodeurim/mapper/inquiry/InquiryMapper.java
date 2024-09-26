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

    // 나의 문의 내역 조회
    public List<InquiryDTO> selectAll(@Param("pagination") Pagination pagination);

    // 문의 목록 전체 개수 조회
    public int selectTotal();
}
