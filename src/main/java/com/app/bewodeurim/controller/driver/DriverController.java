package com.app.bewodeurim.controller.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
// 최상위 경로를 설정하여 컨트롤러를 구분한다.
//@RequestMapping("/driver/*")
@RequiredArgsConstructor
@Slf4j
public class DriverController {
    private final DriverService driverService;

//    회원가입 페이지로 이동
    @GetMapping("/test/join")
    public void goToJoin(DriverDTO driverDTO) {

    }

    //로그인 페이지로 이동
    @PostMapping("/test/join")
    public RedirectView join(DriverDTO driverDTO) {
        driverService.registerDriver(driverDTO);
        return new RedirectView("/driver/login");
    }
}
