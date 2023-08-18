package com.skt.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skt.domain.Customer;
import com.skt.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    //저장하기
    @PostMapping("/customer")
    public void saveCustomer(Customer customer) {
        customerService.saveCustomer(customer);
    }

    //조회하기
    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") String customerId) {
        return customerService.getCustomerById(customerId);
    }
    
    //수정하기
    @PutMapping("/customer")
    public void updateCustomer(Customer customer) {
    	customerService.updateCustomer(customer);
    }
    
    //삭제하기
    @DeleteMapping("/customer/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String customerId) {
    	customerService.deleteCustomer(customerId);
    }    
}