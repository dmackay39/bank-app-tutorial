package com.example.spring_boot_features.repository;

import com.example.spring_boot_features.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Person, Long> {
}
