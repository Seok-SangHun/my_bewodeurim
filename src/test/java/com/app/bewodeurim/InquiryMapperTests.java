package com.app.bewodeurim;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.mapper.inquiry.InquiryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class InquiryMapperTests {
    @Autowired
    private InquiryMapper inquiryMapper;

//    @Test
//    public void testInsert(){
//        InquiryDTO inquiryDTO = new InquiryDTO();
//
//            // 필드 값 설정 (단위 테스트를 위한 값)
//            inquiryDTO.setMemberId(1L);      // 회원 ID
//            inquiryDTO.setInquiryType("환불");                  // 문의 유형 (옵션에서 선택된 값)
//            inquiryDTO.setInquiryTitle("문의합니다");            // 문의 제목
//            inquiryDTO.setInquiryContent("환불 관련 문의 내용");  // 문의 내용
//
//            inquiryMapper.insert(inquiryDTO.toVO());
//
//            log.info("문의가 성공적으로 저장되었습니다. 제목: {}", inquiryDTO.getInquiryTitle());
//
//
//
//        }

    // 1. 임의의 데이터를 생성하여 삽입하는 테스트
    @Test
    public void testInsertInquiries() {
        for (int i = 1; i <= 10; i++) { // 임의로 10개의 데이터를 삽입
            InquiryDTO inquiryDTO = new InquiryDTO();
            inquiryDTO.setMemberId(1L); // 회원 ID 설정
            inquiryDTO.setInquiryType("문의 유형 " + i); // 문의 유형
            inquiryDTO.setInquiryTitle("문의 제목 " + i); // 문의 제목
            inquiryDTO.setInquiryContent("문의 내용 " + i); // 문의 내용

            inquiryMapper.insert(inquiryDTO.toVO()); // 데이터베이스에 삽입
            log.info("삽입된 문의 제목: {}", inquiryDTO.getInquiryTitle());
        }
    }

    // 2. 페이징을 통해 목록 조회하는 테스트
    @Test
    public void testSelectInquiries() {
        Pagination pagination = new Pagination();
        pagination.setPage(1); // 첫 번째 페이지 조회
        pagination.setRowCount(5); // 한 번에 5개의 데이터를 조회

        pagination.setTotal(inquiryMapper.selectTotal()); // 총 데이터 개수 설정
        pagination.progress(); // 페이징 처리 진행

        List<InquiryDTO> inquiries = inquiryMapper.selectAll(pagination); // 페이징된 데이터 조회

        log.info("조회된 문의 목록 크기: {}", inquiries.size());
        inquiries.forEach(inquiry -> log.info("조회된 문의 제목: {}", inquiry.getInquiryTitle()));
    }
}
