package org.demo.interfaceadapters.controller;

import org.demo.entity.Customer;
import org.demo.usecase.CustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class CustomerController {

    private CustomerUseCase customerUseCase;

    @Autowired
    public CustomerController(final CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerUseCase.getCustomers();
    }

    @PostMapping("/customer")
    public Customer save(@RequestBody Customer customer) {
        return customerUseCase.save(customer);
    }
}
