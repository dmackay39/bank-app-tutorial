package com.example.spring_boot_features.service;

import com.example.spring_boot_features.model.CurrentAccount;

import java.util.List;

public interface ICurrentAccountService {
    void deposit(double amount, Long accountId);
    void withdraw(double amount, Long accountId);
    List<CurrentAccount> listUserCurrentAccounts(Long personId);
}
