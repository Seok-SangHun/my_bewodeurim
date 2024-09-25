package com.app.bewodeurim.controller.pickup;

import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.domain.pickup.PickupDTO;
import com.app.bewodeurim.service.pickup.PickupService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PickupController {
    private final PickupService pickupService;
    private final HttpSession session;

    @GetMapping("apply")
    public void goToApplyForm(HttpServletResponse response) {;}

    @GetMapping("/mobile-allRequest/mobile-allRequest-body")
    public void getList(Pagination pagination, String order, Model model){

//        PickupDTO pickupDTO = (PickupDTO) session.getAttribute("pickup");

        if(order == null){
            order = "recent";
        }
        int totalCount = pickupService.getTotal(); // 총 개수 가져오기
        pagination.setTotal(pickupService.getTotal());
        pagination.progress();

        // 게시물 목록과 회원 정보를 모델에 추가
        model.addAttribute("pickups", pickupService.getPickups(pagination, order));
        model.addAttribute("totalCount", totalCount); // 총 개수를 모델에 추가
        model.addAttribute("order", order); // order 값을 모델에 추가
    }

//    @GetMapping("/mobile-detailRequest/mobile-detailRequest-body")
//    public void goTodetailForm(Model model, HttpSession session){
//        PickupDTO pickupDTO = (PickupDTO) session.getAttribute("pickup");
//        model.addAttribute("pickup", pickupDTO);
//    }

//    @GetMapping("/mobile-detailRequest/mobile-detailRequest-body")
//    public void goToDetailForm(@RequestParam("id") Long pickupId, Model model) {
//        // 전달받은 id로 픽업 데이터를 조회
//        Optional<PickupDTO> pickupDTO = pickupService.getPickup(pickupId);
//
//        // 조회된 픽업 데이터를 모델에 추가
//        model.addAttribute("pickup", pickupDTO);
//    }

    @GetMapping("/mobile-detailRequest/mobile-detailRequest-body")
    public void goToDetailForm(@RequestParam("id") Long id, HttpSession session, Model model) {
        // ID로 픽업 데이터 조회
        Optional<PickupDTO> optionalPickupDTO = pickupService.getPickup(id);

        // 픽업 데이터가 존재하는 경우
        if (optionalPickupDTO.isPresent()) {
            PickupDTO pickupDTO = optionalPickupDTO.get();

            // 조회된 픽업 데이터를 세션에 저장
            session.setAttribute("pickup", pickupDTO);

            // 모델에 픽업 데이터 추가
            model.addAttribute("pickup", pickupDTO);
        } else {
            // 데이터가 존재하지 않을 경우 적절한 처리를 추가 (예: 에러 페이지로 리다이렉트)
            model.addAttribute("errorMessage", "픽업 데이터가 존재하지 않습니다.");
        }
    }



}
