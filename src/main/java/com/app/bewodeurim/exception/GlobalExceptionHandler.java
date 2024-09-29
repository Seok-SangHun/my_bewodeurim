package com.app.bewodeurim.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice(basePackages = "com.app.bewodeurim.controller.pickup")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(DriverNotFoundException.class)
    protected RedirectView handleDriverNotFoundException(DriverNotFoundException e) {
        log.error(e.getMessage());
        return new RedirectView("/login/mobile_login?status=false");
    }
}