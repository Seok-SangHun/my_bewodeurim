package com.app.bewodeurim.controller.driver;

import com.app.bewodeurim.domain.area.CityDTO;
import com.app.bewodeurim.domain.area.RegionDTO;
import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.driver.DriverVO;
import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.exception.LoginFailException;
import com.app.bewodeurim.service.driver.DriverService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
// 최상위 경로를 설정하여 컨트롤러를 구분한다.
//@RequestMapping("/driver/*")
@RequiredArgsConstructor
@Slf4j
public class DriverController {
    private final DriverService driverService;
    private final CityDTO cityDTO;
    private final DriverDTO driverDTO;

//    //    회원가입 페이지로 이동
//    @GetMapping("/test/join")
//    public void goToJoin( Model model) {;}
//
//    //로그인 페이지로 이동
//    @PostMapping("/test/join")
//    public RedirectView join(DriverDTO driverDTO, RegionDTO regionDTO , Model model) {
//        driverService.registerDriver(driverDTO);
//        model.addAttribute("cityDTO",cityDTO);
//        model.addAttribute("regionDTO",regionDTO);
//        return new RedirectView("/driver/login");
//    }


//***********************************************************************************************
//    // 회원가입 페이지로 이동
//    @GetMapping("/test/join")
//    public String goToJoin(Model model) {
//        // 도시와 지역 정보를 모델에 추가
//        List<CityDTO> cityList = cityService.getAllCities();      // 모든 도시 정보 가져오기
//        List<RegionDTO> regionList = regionService.getAllRegions(); // 모든 지역 정보 가져오기
//        model.addAttribute("cities", cityList);
//        model.addAttribute("regions", regionList);
//        return "driver/join"; // 가입 페이지의 템플릿 이름
//    }
//
//    // 드라이버 등록 처리
//    @PostMapping("/test/join")
//    public RedirectView join(DriverDTO driverDTO, Model model) {
//        // 드라이버 정보 등록
//        driverService.registerDriver(driverDTO);
//        log.info("Registered Driver: {}", driverDTO);
//
//        // 성공 메시지 또는 다른 페이지로 리다이렉트
//        return  new RedirectView( "/driver/login"); // 로그인 페이지로 리다이렉트
//
//    }

//    ***************************************************************
@GetMapping("/login/mobile_login")
//    @RequestParam(required = false)
//    전달받은 데이터가 null일 경우 required의 default값이 true이기 때문에,
//    NPE가 발생할 수 있다. 이를 필수가 아닌 선택으로(null 허용) 변경하고 싶다면,
//    required 설정을 false로 지정한다.
public void goToLoginForm(@RequestParam(required = false) Boolean status, DriverDTO driverDTO, HttpServletRequest request, Model model){
    log.info("status: {}", status);

    if (status != null && !status) {
        model.addAttribute("errorMessage", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
    }

//        쿠키 조회
    Cookie[] cookies = request.getCookies();

    if (cookies != null){
        for(int i = 0; i < cookies.length; i++){
            log.info(cookies[i].getName());
            //            save라는 key가 있다면,
            if(cookies[i].getName().equals("save")){
                //                해당 value를 화면으로 보낸다.
                model.addAttribute("save", cookies[i].getValue());

            }
            if(cookies[i].getName().equals("memberEmail")){
                driverDTO.setMemberEmail(cookies[i].getValue());
            }

        }
    }

}

    @PostMapping("/login/mobile_login")
//    HttpSession
//    서버의 Session영역을 관리해주는 객체이다.
//    Spring이 해당 객체를 주입해준다.
    public RedirectView login(DriverDTO driverDTO, String save, HttpSession session, HttpServletResponse response){
//        memberService.login(memberDTO.toVO())
//                .ifPresentOrElse(
//                        (member) -> {
//                            log.info(member.toString());
//                            log.info("로그인 성공");
//                        },
//                        () -> {
//                            log.info("로그인 실패");
//                        });

//        // 로그인 시도
        Optional<DriverDTO> foundDriver = driverService.login(driverDTO);
        log.info("foundDriver: {}", foundDriver);
////        null이 아니면 단일 객체 리턴, null이면 예외 발생
        driverDTO = foundDriver.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() + ")로그인 실패");});
//
////        id만 담아놓으면 사용할 때마다 SELECT 쿼리를 발생시켜야 한다(싫어!)
////        session.setAttribute("memberId", memberVO.getId());
////        전체 정보를 담아놓기 때문에 쿼리를 따로 발생시킬 필요 없다(좋아!)
//        session.setAttribute("member", memberVO);


//        화면에서 아이디 저장을 선택했다면 null이 아니다.
        if(save != null){
//            쿠키 생성, 저장
            Cookie saveCookie = new Cookie("save", save);
            Cookie memberEmailCookie = new Cookie("memberEmail", driverDTO.getMemberEmail());

//            -1: 쿠키 계속 유지
            saveCookie.setMaxAge(-1);
            memberEmailCookie.setMaxAge(-1);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);

        }else{
//            쿠키 삭제
            Cookie saveCookie = new Cookie("save", null);
            Cookie memberEmailCookie = new Cookie("memberEmail", null);

            saveCookie.setMaxAge(0);
            memberEmailCookie.setMaxAge(0);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);
        }

        log.info("로그인 성공: {}", driverDTO);
        return new RedirectView( "/mobile-home/mobile-home-body");
    }

//    //    로그 아웃
//    @GetMapping("/driver/logout")
//    public RedirectView logout(HttpSession session){
//        session.invalidate();
//        return new RedirectView("/member/login");
//    }

    //    메인페이지 이동
    @GetMapping("/mobile-home/mobile-home-body")
    public void  goToMobileMain(HttpSession session){
        session.invalidate();
//        return new RedirectView("/main");
    }

}
