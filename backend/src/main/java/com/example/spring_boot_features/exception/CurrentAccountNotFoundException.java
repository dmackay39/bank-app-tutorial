package com.example.spring_boot_features.exception;

public class CurrentAccountNotFoundException extends RuntimeException {
    public CurrentAccountNotFoundException(String message) {
        super(message);
    }
}
