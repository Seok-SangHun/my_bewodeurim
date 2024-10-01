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

    @GetMapping("/payment-success")
    public String paymentSuccess() {
        return "payment/payment-success";
    }

    @GetMapping("/mobile-main")
    public String mobileMain() {
        return "mobile-home/mobile-home-body";
    }

    @GetMapping("/header")
    public String header() { return "header-logout"; }

    }



