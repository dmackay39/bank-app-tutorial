package com.example.spring_boot_features.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class CurrentAccount extends BankAccount{
    public CurrentAccount(Long id, double balance, Person owner) {
        this.setId(id);
        this.setBalance(balance);
        this.setOwner(owner);
    }
}
