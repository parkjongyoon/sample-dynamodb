package com.skt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skt.domain.Customer;
import com.skt.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * 저장하기
     */
    @GetMapping("/customer/saveCustomer")
    public void saveCustomer() {
        customerService.saveCustomer();
    }

    /**
     * 가져오기
     * @param customerId
     * @return
     */
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") String customerId) {
        return customerService.getCustomerById(customerId);
    }
}