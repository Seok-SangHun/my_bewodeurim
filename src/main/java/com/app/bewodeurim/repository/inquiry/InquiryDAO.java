package com.app.bewodeurim.repository.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.mapper.inquiry.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InquiryDAO {
    private final InquiryMapper inquiryMapper;

    // 1:1 문의 작성
    public void save(InquiryVO inquiryVO) {
        inquiryMapper.insert(inquiryVO);
    }

}
