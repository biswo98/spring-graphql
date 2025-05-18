package com.example.graphql.repository;

import com.example.graphql.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{
    Customer findCustomerByEmail(String email);
}
