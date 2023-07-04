package com.example.doan3.service;

import com.example.doan3.entity.Customer;
import com.example.doan3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void insertCustomerToDatabase(Customer customer){
        customerRepository.save(customer);
    }
}
