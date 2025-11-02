package com.example.spring_boot_features.serviceImpls;

import com.example.spring_boot_features.exception.CurrentAccountNotFoundException;
import com.example.spring_boot_features.exception.InsufficientFundsException;
import com.example.spring_boot_features.exception.InvalidWithdrawalAmountException;
import com.example.spring_boot_features.model.CurrentAccount;
import com.example.spring_boot_features.repository.CurrentAccountsRepository;
import com.example.spring_boot_features.service.ICurrentAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrentAccountServiceImpl implements ICurrentAccountService {

    private final CurrentAccountsRepository accountsRepository;

    @Override
    @Transactional
    public void deposit(double amount, Long accountId) {
        CurrentAccount currentAccount = accountsRepository.findById(accountId)
                .orElseThrow(() -> new CurrentAccountNotFoundException("Account with id: " + accountId +" not found"));

        if (amount <= 0) {
            throw new RuntimeException("Deposit amount must be greater than zero");
        }

        currentAccount.setBalance(currentAccount.getBalance() + amount);
    }

    @Override
    @Transactional
    public void withdraw(double amount, Long accountId) {
        CurrentAccount currentAccount = accountsRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account with id: " + accountId + " not found"));

        if (amount <= 0) {
            throw new InvalidWithdrawalAmountException("Withdrawal amount must be greater than zero");
        }

        if (currentAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in account with id: " + accountId);
        }

        currentAccount.setBalance(currentAccount.getBalance() - amount);
    }

    @Override
    public List<CurrentAccount> listUserCurrentAccounts(Long personId) {
        List<CurrentAccount> accounts = accountsRepository.findByOwnerId(personId);
        if (accounts.isEmpty()) {
            throw new RuntimeException("No current accounts found for person with id: " + personId);
        }
        return accounts;
    }
}
