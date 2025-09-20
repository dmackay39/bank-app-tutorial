package com.example.spring_boot_features.serviceImpls;

import com.example.spring_boot_features.repository.CustomerRepository;
import com.example.spring_boot_features.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public boolean checkCustomerExists(Long personId) {
        return customerRepository.existsById(personId);
    }
}
