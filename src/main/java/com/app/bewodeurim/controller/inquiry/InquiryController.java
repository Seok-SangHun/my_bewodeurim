package com.app.bewodeurim.controller.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.service.inquiry.InquiryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class InquiryController {
    private InquiryService inquiryService;

    // 문의 페이지로 이동(GET)

    public void goToInquiry() {}
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
