package com.example.spring_boot_features.exception;

public class InvalidWithdrawalAmountException extends RuntimeException {
    public InvalidWithdrawalAmountException(String message) {
        super(message);
    }
}
