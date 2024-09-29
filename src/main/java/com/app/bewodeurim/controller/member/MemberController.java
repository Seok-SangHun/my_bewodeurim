package com.app.bewodeurim.controller.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    @GetMapping("join1")
    public String goTojoin1() {
        return "/signup/driver_signup1";
    }

    @GetMapping("join2")
    public String goTojoin2() {
        return "/signup/driver_signup2";
    }

    @GetMapping("join3")
    public String goTojoin3() {
        return "/signup/driver_signup3";
    }
}
