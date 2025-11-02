package com.example.spring_boot_features.controller;

import com.example.spring_boot_features.DTO.CurrentAccountDTO;
import com.example.spring_boot_features.exception.CustomerNotFoundException;
import com.example.spring_boot_features.service.ICurrentAccountService;
import com.example.spring_boot_features.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrentAccountController {
    private final ICurrentAccountService currentAccountService;
    private final ICustomerService customerService;

    @GetMapping("/current-accounts/{id}")
    public List<CurrentAccountDTO> listCurrentAccountsForUser(@PathVariable("id") Long personId) {

        if (!customerService.checkCustomerExists(personId)) {
            throw new CustomerNotFoundException("Customer with ID " + personId + " does not exist.");
        }
        return currentAccountService.listUserCurrentAccounts(personId)
                .stream()
                .map(account -> new CurrentAccountDTO(account.getId(), account.getBalance()))
                .toList();
    }

    @PostMapping("/current-accounts/transfer")
    public void transferFunds(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam double amount) {
        currentAccountService.withdraw(amount, fromAccountId);
        currentAccountService.deposit(amount, toAccountId);
    }
}
