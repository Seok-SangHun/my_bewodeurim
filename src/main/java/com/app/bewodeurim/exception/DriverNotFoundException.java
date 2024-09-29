package com.app.bewodeurim.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(String message) {
        super(message);
    }
}
