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
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class InquiryController {
    private InquiryService inquiryService;

//    // 1:1 상담 문의 페이지로 이동(GET)
//    @GetMapping("/one-to-one")
//    public void goToOneToOne(InquiryDTO inquiryDTO, HttpSession session) {;}
//
//    // 1:1 상담 문의 작성 완료(POST)
//    @PostMapping("/one-to-one")
//    public RedirectView write(InquiryDTO inquiryDTO) {
//        inquiryService.write(inquiryDTO.toVO());
//        return new RedirectView("/one-to-one");
//    }

    // 1:1 상담 문의 페이지로 이동(GET)
    @GetMapping("/one-to-one")
    public String goToOneToOne(Model model, InquiryDTO inquiryDTO, HttpSession session) {
        model.addAttribute("inquiryDTO", inquiryDTO);  // 필요한 경우 inquiryDTO를 모델에 추가
        return "inquiry/one-to-one";  // inquiry 패키지의 one-to-one.html 템플릿을 반환
    }

    // 1:1 상담 문의 작성 완료(POST)
    @PostMapping("/one-to-one")
    public RedirectView write(InquiryDTO inquiryDTO) {
        inquiryService.write(inquiryDTO.toVO());
        return new RedirectView("/inquiry/one-to-one");
    }
}
