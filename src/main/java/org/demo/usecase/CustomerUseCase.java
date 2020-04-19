package org.demo.usecase;

import lombok.extern.slf4j.Slf4j;
import org.demo.entity.Customer;
import org.demo.interfaceadapters.database.mongo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CustomerUseCase {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerUseCase(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer save(Customer customer) {
        log.info("Customer: {}", customer.toString());
        customer.generateLastName();
        return customerRepository.save(customer);
    }
}