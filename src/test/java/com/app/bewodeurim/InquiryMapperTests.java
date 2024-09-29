package com.app.bewodeurim;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.mapper.inquiry.InquiryMapper;
import com.app.bewodeurim.mapper.member.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
public class InquiryMapperTests {
    @Autowired
    private InquiryMapper inquiryMapper;

    @Test
    public void testInsertMultipleInquiries() {
        // 임의의 데이터를 여러 개 생성하여 삽입
        for (int i = 1; i <= 5; i++) {
            InquiryDTO inquiryDTO = new InquiryDTO();
            inquiryDTO.setMemberId(1L); // 테스트용 memberId
            inquiryDTO.setInquiryTitle("테스트 제목 " + i);
            inquiryDTO.setInquiryContent("테스트 내용 " + i);
            inquiryDTO.setInquiryType("1"); // 1: 수거문의

            // DB에 삽입
            inquiryMapper.insertInquiry(inquiryDTO);
        }

        // 삽입된 데이터 확인을 위한 로그
        System.out.println("5개의 테스트 문의가 DB에 삽입되었습니다.");
    }

    @Test
    public void testSelectInquiries() {
        // 삽입된 모든 데이터를 조회
        List<InquiryDTO> inquiries = inquiryMapper.selectAllInquiries();

        // 조회된 데이터를 로그로 출력
        inquiries.forEach(inquiry -> System.out.println(inquiry));

    }

//    @Test
//    public void testInsertSingleInquiry() {
//        // 삽입된 테스트 회원의 ID를 직접 사용 (예: SELECT로 확인한 ID)
//        Long testMemberId = 1L; // 실제로 존재하는 회원 ID로 변경
//
//        // 1개의 상담 데이터를 삽입하는 테스트
//        InquiryDTO inquiryDTO = new InquiryDTO();
//        inquiryDTO.setMemberId(testMemberId); // 삽입된 회원 ID 사용
//        inquiryDTO.setInquiryType("일반 문의"); // 문의 유형
//        inquiryDTO.setInquiryTitle("테스트 문의 제목"); // 문의 제목
//        inquiryDTO.setInquiryContent("이것은 테스트 문의 내용입니다."); // 문의 내용
//
//        inquiryMapper.insert(inquiryDTO.toVO()); // 데이터베이스에 삽입
//        log.info("삽입된 문의 제목: {}", inquiryDTO.getInquiryTitle());
//
//        // 데이터 삽입 후 로그 출력
//        log.info("1개의 상담 내역이 성공적으로 삽입되었습니다.");
//    }

//    // 1. 특정 회원의 상담 내역을 페이징하여 조회하는 테스트 (실전용)
//    @Test
//    public void testSelectByMemberId() {
//        Long testMemberId = 1L;  // 테스트용 회원 ID (실제 존재하는 ID로 설정)
//
//        // 페이징 정보 설정
//        Pagination pagination = new Pagination();
//        pagination.setPage(1); // 첫 번째 페이지 조회
//        pagination.setRowCount(10); // 한 페이지에 10개씩 조회
//
//        // 총 데이터 개수 설정 (특정 회원에 대한 상담 내역 수)
//        pagination.setTotal(inquiryMapper.selectTotal());
//        pagination.progress(); // 페이징 정보 계산
//
//        // 특정 회원의 상담 내역 조회
//        List<InquiryDTO> inquiries = inquiryMapper.selectByMemberId(testMemberId, pagination);
//
//        // 조회된 결과 검증 및 로그 출력
//        log.info("조회된 문의 목록 크기: {}", inquiries.size());
//        inquiries.forEach(inquiry -> log.info("조회된 문의 제목: {}", inquiry.getInquiryTitle()));
//
//        // 단위 테스트 검증 (예: 문의 목록이 0보다 커야 함)
//        assert inquiries.size() > 0 : "조회된 상담 내역이 없습니다.";
//    }
//}

    // 1. 임의로 MemberId를 설정하여 더보기 방식으로 상담 내역을 조회하는 테스트
    @Test
    public void testSelectByMemberIdWithLoadMore() {
        Long testMemberId = 1L; // 임의의 회원 ID 설정 (존재하지 않아도 무관)

        // 임의로 30개의 상담 데이터를 삽입 (10개씩 두 번에 나눠서 조회 테스트)
        for (int i = 1; i <= 30; i++) {
            InquiryDTO inquiryDTO = new InquiryDTO();
            inquiryDTO.setMemberId(testMemberId);  // 임의의 회원 ID 설정
            inquiryDTO.setInquiryType("문의 유형 " + i);
            inquiryDTO.setInquiryTitle("문의 제목 " + i);
            inquiryDTO.setInquiryContent("문의 내용 " + i);

            inquiryMapper.insert(inquiryDTO.toVO()); // 데이터베이스에 삽입
            log.info("삽입된 문의 제목: {}", inquiryDTO.getInquiryTitle());
        }

        // 더보기 방식 첫 번째 조회 (처음 10개 데이터)
        Pagination pagination = new Pagination();
        pagination.setPage(1); // 첫 번째 페이지
        pagination.setRowCount(10); // 한 번에 10개씩 조회
        pagination.setTotal(inquiryMapper.selectTotal());
        pagination.progress(); // 페이징 처리 진행

        // 첫 번째 조회로 10개의 상담 내역을 조회
        List<InquiryDTO> inquiriesPage1 = inquiryMapper.selectByMemberId(testMemberId, pagination);

        // 첫 번째 페이지 결과 검증 및 로그 출력
        log.info("조회된 문의 목록 크기 (첫 번째 조회): {}", inquiriesPage1.size());
        inquiriesPage1.forEach(inquiry -> log.info("조회된 문의 제목: {}", inquiry.getInquiryTitle()));

        // 두 번째 더보기 클릭 (다음 10개 데이터)
        pagination.setPage(2); // 두 번째 페이지 (다음 10개)
        pagination.progress(); // 페이징 정보 갱신
        List<InquiryDTO> inquiriesPage2 = inquiryMapper.selectByMemberId(testMemberId, pagination);

        // 두 번째 페이지 결과 검증 및 로그 출력
        log.info("조회된 문의 목록 크기 (두 번째 조회): {}", inquiriesPage2.size());
        inquiriesPage2.forEach(inquiry -> log.info("조회된 문의 제목: {}", inquiry.getInquiryTitle()));

        // 단위 테스트 검증
        assert inquiriesPage1.size() == 10 : "첫 번째 조회된 데이터가 10개가 아닙니다.";
        assert inquiriesPage2.size() == 10 : "두 번째 조회된 데이터가 10개가 아닙니다.";
    }
}


