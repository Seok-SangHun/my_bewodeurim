package com.app.bewodeurim.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice(basePackages = "com.app.threetier.controller.member")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(LoginFailException.class)
    protected RedirectView handleLoginFailException(LoginFailException e) {
        log.error(e.getMessage());
        return new RedirectView("/member/login?status=false");
    }
}
