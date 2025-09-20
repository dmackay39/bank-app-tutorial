package com.example.spring_boot_features.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@MappedSuperclass
@Data
public abstract class BankAccount {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Setter
    private double balance;

    @ManyToOne
    private Person owner;
}
