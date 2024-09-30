package com.app.bewodeurim.controller.inquiry;

import com.app.bewodeurim.domain.inquiry.FaqDTO;
import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.service.inquiry.FaqService;
import com.app.bewodeurim.service.inquiry.InquiryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class InquiryController {
    private final InquiryService inquiryService;
    private final HttpSession session;
    private final FaqService faqService;

//    // inquiry/inquiry 경로로 GET 요청을 처리하고, 검색 후 faq 페이지로 이동
//    @GetMapping("/inquiry/inquiry")
//    public String searchInquiryAndRedirect(@RequestParam(value = "query", required = false) String query, Model model, RedirectAttributes redirectAttributes) {
//        // 검색어가 없는 경우 빈 값 처리
//        if (query != null && !query.isEmpty()) {
//            List<String> searchResults = searchInquiry(query);
//
//            // 검색 결과가 있다면 검색어를 faq로 전달
//            if (!searchResults.isEmpty()) {
//                redirectAttributes.addAttribute("query", query); // 검색어 전달
//                return "redirect:/faq/faq";
//            }
//
//            // 검색 결과가 없으면 메시지를 모델에 추가하여 다시 inquiry 페이지로 이동
//            model.addAttribute("noResults", true);
//        }
//
//        // 검색어가 없거나 검색 결과가 없으면 inquiry 페이지를 그대로 반환
//        return "inquiry/inquiry"; // inquiry.html 템플릿 반환
//    }
//
//    // 검색 로직 (임시 데이터 사용)
//    private List<String> searchInquiry(String query) {
//        List<String> allInquiries = Arrays.asList(
//
//        );
//
//        // 간단한 검색 로직: 검색어를 포함한 문의 항목 필터링
//        return allInquiries.stream()
//                .filter(inquiry -> inquiry.toLowerCase().contains(query.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    // faq/faq 경로로 GET 요청을 처리하고, faq.html 페이지를 반환
//    @GetMapping("/faq/faq")
//    public String showFaqPage(@RequestParam(value = "query", required = false) String query, Model model) {
//        // 검색어가 전달되었을 경우 처리
//        if (query != null && !query.isEmpty()) {
//            model.addAttribute("query", query); // 검색어를 모델에 추가
//        }
//
//        return "faq/faq"; // faq.html 페이지 반환
//    }


    // 1:1 상담 문의 페이지 (GET)
    @GetMapping("/one-to-one/one-to-one")
    public void goToOnetoOne(InquiryDTO inquiryDTO) {

    }

//    // 1:1 상담 문의 작성완료 (POST)
//    @PostMapping("/one-to-one/one-to-one")
//    public RedirectView write(InquiryDTO inquiryDTO, HttpSession session) {
//        session.setAttribute("newInquiry", inquiryDTO); // 세션에 저장
//        inquiryService.write(inquiryDTO.toVO()); // DB에 저장
//
//        return new RedirectView("/one-to-one/my_counsel"); // 페이지 이동
//    }

//    // 1:1 상담 문의 작성완료 (POST)
//    @PostMapping("/one-to-one/one-to-one")
//    public String write(InquiryDTO inquiryDTO, HttpSession session) {
//        Long memberId = (Long) session.getAttribute("memberId"); // 세션에서 회원 ID 가져옴
//        inquiryDTO.setMemberId(memberId); // DTO에 회원 ID 설정
//        inquiryService.write(inquiryDTO.toVO()); // DB에 저장
//
//        return "redirect:/one-to-one/my_counsel"; // 상담 내역 페이지로 리다이렉트
//    }
//
//    // 1:1 상담 문의 목록 조회 (GET)
//    @GetMapping("/one-to-one/my_counsel")
//    public String showMyCounselList(HttpSession session, Model model, Pagination pagination) {
//        Long memberId = (Long) session.getAttribute("memberId"); // 로그인된 회원 ID를 세션에서 가져옴
//
//        if (memberId != null) {
//            // 상담 내역 목록을 페이징 처리하여 가져옴
//            List<InquiryDTO> inquiries = inquiryService.getListByMemberId(memberId, pagination);
//
//            // 조회된 상담 내역 및 페이징 정보를 모델에 추가
//            model.addAttribute("inquiries", inquiries);
//            model.addAttribute("pagination", pagination);
//        }
//        // my_counsel.html로 이동
//        return "one-to-one/my_counsel";
//    }

//    // 1:1 상담 문의 작성완료 (POST) (잠시 주석처리)
//    @PostMapping("/one-to-one/one-to-one")
//    public String write(InquiryDTO inquiryDTO, HttpSession session, Model model) {
//        Long memberId = (Long) session.getAttribute("memberId"); // 세션에서 회원 ID 가져옴
//        inquiryDTO.setMemberId(memberId); // DTO에 회원 ID 설정
//        inquiryService.registerInquiry(inquiryDTO); // DB에 저장
//
//        // INSERT 후 데이터 조회
//        List<InquiryDTO> inquiries = inquiryService.getAllInquiries(); // 모든 문의 조회
//        model.addAttribute("inquiries", inquiries); // 조회된 문의 목록을 모델에 추가
//
//        return "redirect:/one-to-one/my_counsel"; // 상담 내역 페이지로 리다이렉트
//    }

////    1:1 상담 문의 작성완료 (POST)
//    @PostMapping("/one-to-one/one-to-one")
//    public String writeInquiry(InquiryDTO inquiryDTO, HttpSession session) {
//        // memberId가 없으면 테스트용 임시 값을 설정
//        Long testMemberId = 1L; // 테스트용 임의의 memberId
//        inquiryDTO.setMemberId(testMemberId);
//
//        // DB에 저장
//        inquiryService.registerInquiry(inquiryDTO);
//
//        return "redirect:/one-to-one/my_counsel"; // 상담 내역 페이지로 리다이렉트
//    }

    @PostMapping("/one-to-one/one-to-one")
    public RedirectView writeInquiry(InquiryDTO inquiryDTO, HttpSession session) {
        Long memberId = (Long) session.getAttribute("memberId");

        // memberId가 세션에서 없으면 테스트용 임시 값을 사용
        if (memberId == null) {
            memberId = 1L; // 테스트용 memberId
        }

        inquiryDTO.setMemberId(memberId);
        log.info("{}", inquiryDTO);
        inquiryService.registerInquiry(inquiryDTO); // DB에 저장

        return new RedirectView("/one-to-one/my_counsel"); // 상담 내역 페이지로 리다이렉트
    }

    // 상담 내역 목록 조회 (GET)
    @GetMapping("/one-to-one/my_counsel")
    public void showMyCounselList(HttpSession session, Model model, Pagination pagination) {
        Long memberId = (Long) session.getAttribute("memberId"); // 세션에서 회원 ID를 가져옴
        if (memberId != null) {
            List<InquiryDTO> inquiries = inquiryService.getListByMemberId(memberId, pagination);
            model.addAttribute("inquiries", inquiries);
            model.addAttribute("pagination", pagination);
        }
    }

    // inquiry/inquiry 경로로 GET 요청을 처리하여 페이지를 출력
    @GetMapping("/inquiry/inquiry")
    public String showInquiryPage() {
        // inquiry.html 템플릿을 반환
        return "/inquiry/inquiry"; // templates/inquiry/inquiry.html
    }

    // faq/faq 경로로 GET 요청을 처리하여 페이지를 출력
    @GetMapping("/faq/faq")
    public String showFaqList(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 15; // 한 번에 표시할 FAQ 수
        List<FaqDTO> faqList = faqService.getFaqList(page, pageSize); // 페이지에 맞는 FAQ 목록 조회
        int totalCount = faqService.getTotalCount(); // 전체 FAQ 수 가져오기

        model.addAttribute("faqList", faqList);
        model.addAttribute("totalCount", totalCount); // 전체 FAQ 수 전달
        model.addAttribute("currentPage", page); // 현재 페이지 전달
        return "faq/faq"; // faq.html로 반환
    }

    @GetMapping("/faq/loadMore")
    @ResponseBody
    public Map<String, Object> loadMoreFaqs(@RequestParam(defaultValue = "1") int page) {
        int pageSize = 10;
        List<FaqDTO> faqList = faqService.getFaqList(page, pageSize);
        int totalCount = faqService.getTotalCount();

        Map<String, Object> response = new HashMap<>();
        response.put("faqList", faqList);
        response.put("totalCount", totalCount);

        return response;
    }
}

