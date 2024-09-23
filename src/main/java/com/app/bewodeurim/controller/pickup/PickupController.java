package com.app.bewodeurim.controller.pickup;

import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.service.pickup.PickupService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pickup/*")
@RequiredArgsConstructor
@Slf4j
public class PickupController {
    private final PickupService pickupService;
    private final HttpSession session;

    @GetMapping("apply")
    public void goToApplyForm(HttpServletResponse response) {}

    @GetMapping("list")
    public void getList(Pagination pagination, Model model){
        // 현재 로그인한 회원 정보를 세션에서 가져오기
        MemberVO memberVO = (MemberVO) session.getAttribute("member");

        pagination.setTotal(pickupService.getTotal());
        pagination.progress();

        // 게시물 목록과 회원 정보를 모델에 추가
        model.addAttribute("pickups", pickupService.getPickups(pagination));
        model.addAttribute("member", memberVO); // 세션에서 가져온 회원 정보를 모델에 추가
    }
}
