package com.app.bewodeurim.Inquiry;

import com.app.bewodeurim.domain.inquiry.FaqDTO;
import com.app.bewodeurim.service.inquiry.FaqServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FaqServiceImplTests { // 클래스 이름을 Tests로 변경

    private FaqServiceImpl faqService;

    @BeforeEach
    public void setUp() {
        // 하드코딩된 데이터를 사용하는 FaqServiceImpl 인스턴스 생성
        faqService = new FaqServiceImpl();
    }

    @Test
    public void testGetFaqList_FirstPage() {
        // Given: 첫 번째 페이지 요청
        int page = 1;
        int pageSize = 10;

        // When: FAQ 목록을 가져옴
        List<FaqDTO> faqList = faqService.getFaqList(page, pageSize);

        // Then: 반환된 FAQ 목록이 null이 아니며, 크기가 10인지 확인
        assertNotNull(faqList);
        assertEquals(10, faqList.size());

        // 첫 번째 질문과 답변이 예상대로 나오는지 확인
        assertEquals("질문1", faqList.get(0).getQuestion());
        assertEquals("답변1", faqList.get(0).getAnswer());
    }

    @Test
    public void testGetFaqList_SecondPage() {
        // Given: 두 번째 페이지 요청
        int page = 2;
        int pageSize = 10;

        // When: FAQ 목록을 가져옴
        List<FaqDTO> faqList = faqService.getFaqList(page, pageSize);

        // Then: 반환된 FAQ 목록이 null이 아니며, 크기가 10인지 확인
        assertNotNull(faqList);
        assertEquals(10, faqList.size());

        // 두 번째 페이지 첫 번째 질문과 답변이 예상대로 나오는지 확인
        assertEquals("질문11", faqList.get(0).getQuestion());
        assertEquals("답변11", faqList.get(0).getAnswer());
    }

    @Test
    public void testGetFaqList_LastPage() {
        // Given: 마지막 페이지 요청
        int page = 3;
        int pageSize = 10;

        // When: FAQ 목록을 가져옴
        List<FaqDTO> faqList = faqService.getFaqList(page, pageSize);

        // Then: 반환된 FAQ 목록이 null이 아니며, 마지막 페이지 크기가 10인지 확인
        assertNotNull(faqList);
        assertEquals(10, faqList.size());

        // 마지막 질문과 답변이 예상대로 나오는지 확인
        assertEquals("질문21", faqList.get(0).getQuestion());
        assertEquals("답변21", faqList.get(0).getAnswer());
    }

    @Test
    public void testGetTotalCount() {
        // When: 전체 FAQ 수를 가져옴
        int totalCount = faqService.getTotalCount();

        // Then: 전체 FAQ 수가 30개인지 확인 (하드코딩된 값)
        assertEquals(30, totalCount);
    }
}
