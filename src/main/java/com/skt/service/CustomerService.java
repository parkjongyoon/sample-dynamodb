package com.skt.service;

import org.springframework.stereotype.Service;

import com.skt.domain.Customer;
import com.skt.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
    private final CustomerRepository customerRepository;
    
    public void saveCustomer() {
        customerRepository.saveCustomer();
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.getCustomerById(customerId);
    }
}