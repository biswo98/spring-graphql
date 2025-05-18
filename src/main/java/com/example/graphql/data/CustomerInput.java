package com.example.graphql.data;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class CustomerInput {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;


    public Customer getCustomerEntity() {
        Customer customerEntity= new Customer();
        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerEntity.setEmail(email);
        customerEntity.setPhoneNumber(phoneNumber);
        customerEntity.setAddress(address);
        customerEntity.setCity(city);
        return customerEntity;
    }


}
