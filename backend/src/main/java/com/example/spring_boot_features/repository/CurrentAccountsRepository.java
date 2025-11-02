package com.example.spring_boot_features.repository;

import com.example.spring_boot_features.model.CurrentAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentAccountsRepository extends CrudRepository<CurrentAccount, Long> {
    List<CurrentAccount> findByOwnerId(Long ownerId);
}
