package org.uniara.CustomerService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniara.CustomerService.model.Customer;
import org.uniara.CustomerService.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }
}
