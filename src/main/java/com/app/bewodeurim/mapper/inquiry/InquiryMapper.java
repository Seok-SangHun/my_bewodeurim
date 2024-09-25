package com.app.bewodeurim.mapper.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryMapper {
    //  1:1 문의 작성
    public void insert(InquiryVO inquiryVO);
}
