package com.app.bewodeurim;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.mapper.inquiry.InquiryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InquiryMapperTests {
    @Autowired
    private InquiryMapper inquiryMapper;

    @Test
    public void testInsert(){
        InquiryDTO inquiryDTO = new InquiryDTO();

        // 필드 값 설정 (단위 테스트를 위한 값)
        inquiryDTO.setMemberId(1L);      // 회원 ID
        inquiryDTO.setInquiryType("SKT");                 // 문의 유형 (옵션에서 선택된 값)
        inquiryDTO.setInquiryTitle("문의합니다");            // 문의 제목
        inquiryDTO.setInquiryContent("SKT 관련 문의 내용");   // 문의 내용

        inquiryMapper.insert(inquiryDTO.toVO());
    }
}
