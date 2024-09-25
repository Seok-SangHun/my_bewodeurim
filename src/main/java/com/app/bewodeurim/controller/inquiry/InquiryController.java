package com.app.bewodeurim.controller.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.service.inquiry.InquiryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class InquiryController {
    private InquiryService inquiryService;

    // inquiry/inquiry 경로로 GET 요청을 처리하고, 검색 후 faq 페이지로 이동
    @GetMapping("/inquiry/inquiry")
    public String searchInquiryAndRedirect(@RequestParam(value = "query", required = false) String query, Model model, RedirectAttributes redirectAttributes) {
        // 검색어가 없는 경우 빈 값 처리
        if (query != null && !query.isEmpty()) {
            List<String> searchResults = searchInquiry(query);

            // 검색 결과가 있다면 검색어를 faq로 전달
            if (!searchResults.isEmpty()) {
                redirectAttributes.addAttribute("query", query); // 검색어 전달
                return "redirect:/faq/faq";
            }

            // 검색 결과가 없으면 메시지를 모델에 추가하여 다시 inquiry 페이지로 이동
            model.addAttribute("noResults", true);
        }

        // 검색어가 없거나 검색 결과가 없으면 inquiry 페이지를 그대로 반환
        return "inquiry/inquiry"; // inquiry.html 템플릿 반환
    }

    // 검색 로직 (임시 데이터 사용)
    private List<String> searchInquiry(String query) {
        List<String> allInquiries = Arrays.asList(
                "What is the subscription plan?",
                "How can I change my subscription?",
                "What are the recycling instructions?",
                "How to cancel my subscription?"
        );

        // 간단한 검색 로직: 검색어를 포함한 문의 항목 필터링
        return allInquiries.stream()
                .filter(inquiry -> inquiry.toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    // faq/faq 경로로 GET 요청을 처리하고, faq.html 페이지를 반환
    @GetMapping("/faq/faq")
    public String showFaqPage(@RequestParam(value = "query", required = false) String query, Model model) {
        // 검색어가 전달되었을 경우 처리
        if (query != null && !query.isEmpty()) {
            model.addAttribute("query", query); // 검색어를 모델에 추가
        }

        return "faq/faq"; // faq.html 페이지 반환
    }

    // 1:1 상담 문의 페이지로 이동(GET)
    @GetMapping("/one-to-one/one-to-one")
    public void goToOnetoOne(InquiryDTO inquiryDTO, HttpSession session) {;}

    // 1:1 상담 문의 페이지 작성 완료(POST)
    @PostMapping("/one-to-one/one-to-one")
    public RedirectView completeInquiry(InquiryDTO inquiryDTO) {
        inquiryService.completeInquiry(inquiryDTO.toVO());
        return new RedirectView("/one-to-one/my_counsel");
    }
}
