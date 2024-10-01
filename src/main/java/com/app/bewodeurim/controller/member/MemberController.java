package com.app.bewodeurim.controller.member;

import com.app.bewodeurim.domain.area.RegionDTO;
import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.exception.LoginFailException;
import com.app.bewodeurim.service.member.MemberService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login/web_login_signup")
    public String goToLoginSignupForm(){
        return "login/web_login_signup";
    }

    @GetMapping("/login/web_login")
//    @RequestParam(required = false)
//    전달받은 데이터가 null일 경우 required의 default값이 true이기 때문에,
//    NPE가 발생할 수 있다. 이를 필수가 아닌 선택으로(null 허용) 변경하고 싶다면,
//    required 설정을 false로 지정한다.
    public void goToLoginForm(@RequestParam(required = false) Boolean status, MemberDTO memberDTO, HttpServletRequest request, Model model){
        log.info("status: {}", status);

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
                    memberDTO.setMemberEmail(cookies[i].getValue());
                }

            }
        }

    }

    @PostMapping("/login/web_login")
//    HttpSession
//    서버의 Session영역을 관리해주는 객체이다.
//    Spring이 해당 객체를 주입해준다.
    public RedirectView login(MemberDTO memberDTO, String save, HttpSession session, HttpServletResponse response){
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
        Optional<MemberVO> foundMember = memberService.login(memberDTO.toVO());
//
////        null이 아니면 단일 객체 리턴, null이면 예외 발생
        MemberVO memberVO = foundMember.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() + ")로그인 실패");});
//
////        id만 담아놓으면 사용할 때마다 SELECT 쿼리를 발생시켜야 한다(싫어!)
////        session.setAttribute("memberId", memberVO.getId());
////        전체 정보를 담아놓기 때문에 쿼리를 따로 발생시킬 필요 없다(좋아!)
//        session.setAttribute("member", memberVO);


//        화면에서 아이디 저장을 선택했다면 null이 아니다.
        if(save != null){
//            쿠키 생성, 저장
            Cookie saveCookie = new Cookie("save", save);
            Cookie memberEmailCookie = new Cookie("memberEmail", memberDTO.getMemberEmail());

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

        log.info("로그인 성공: {}", memberVO);
        return new RedirectView( "/main");
    }

    //    로그 아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/member/login");
    }

    //    메인페이지 이동
    @GetMapping("/main")
    public void  goToWebMain(HttpSession session){
        session.invalidate();
//        return new RedirectView("/main");
    }
}
