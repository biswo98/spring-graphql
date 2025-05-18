package com.example.graphql.controller;

import com.example.graphql.data.Customer;
import com.example.graphql.data.CustomerInput;
import com.example.graphql.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;


    @QueryMapping
    public Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public Customer customerByEmail(@Argument String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @MutationMapping
    public Customer addCustomer(@Argument(name="input") CustomerInput customerInput) {
        return customerRepository.save(customerInput.getCustomerEntity());
    }
}
