package com.app.bewodeurim.controller.driver;

import com.app.bewodeurim.domain.area.CityDTO;
import com.app.bewodeurim.domain.area.RegionDTO;
import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final CityDTO cityDTO;

    //    회원가입 페이지로 이동
    @GetMapping("/test/join")
    public void goToJoin( Model model) {;}

    //로그인 페이지로 이동
    @PostMapping("/test/join")
    public RedirectView join(DriverDTO driverDTO, RegionDTO regionDTO , Model model) {
        driverService.registerDriver(driverDTO);
        model.addAttribute("cityDTO",cityDTO);
        model.addAttribute("regionDTO",regionDTO);
        return new RedirectView("/driver/login");
    }
}
