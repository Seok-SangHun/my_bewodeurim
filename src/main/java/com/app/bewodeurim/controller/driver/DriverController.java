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

import java.util.List;

@Controller
// 최상위 경로를 설정하여 컨트롤러를 구분한다.
//@RequestMapping("/driver/*")
@RequiredArgsConstructor
@Slf4j
public class DriverController {
    private final DriverService driverService;
    private final CityDTO cityDTO;

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
//    public String join(DriverDTO driverDTO, Model model) {
//        // 드라이버 정보 등록
//        driverService.registerDriver(driverDTO);
//        log.info("Registered Driver: {}", driverDTO);
//
//        // 성공 메시지 또는 다른 페이지로 리다이렉트
//        return "redirect:/driver/login"; // 로그인 페이지로 리다이렉트
//    }

}
