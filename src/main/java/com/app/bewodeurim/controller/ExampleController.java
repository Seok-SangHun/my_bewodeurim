package com.app.bewodeurim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
    @GetMapping("/main")
    public void main(){;}

    @GetMapping("/payment")
    public String payment() {
        return "payment/payment";
    }


}
