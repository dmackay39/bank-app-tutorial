package com.example.spring_boot_features.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SavingsAccount extends BankAccount implements PaysInterest {

    private double interestRate;

    @Override
    public double calculateInterest() {
        return this.getBalance() * this.getInterestRate() / 100;
    }

    @Override
    public void payInterest() {
        this.setBalance(this.getBalance() + calculateInterest());
    }


}
