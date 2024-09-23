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
        inquiryDTO.setMemberId("kss1234@gmail.com");
        inquiryDTO.setInquiryType("SKT");
        inquiryDTO.setInquiryTitle("문의합니다");
        inquiryDTO.setCreatedDate("20240923");
        inquiryDTO.setUpdatedDate("20240923");
    }
}