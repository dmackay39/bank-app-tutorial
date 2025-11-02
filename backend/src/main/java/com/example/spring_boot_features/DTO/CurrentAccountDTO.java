package com.example.spring_boot_features.DTO;

import lombok.Data;
import lombok.NonNull;

@Data
public class CurrentAccountDTO {

    @NonNull
    private Long id;

    @NonNull
    private double balance;
}
