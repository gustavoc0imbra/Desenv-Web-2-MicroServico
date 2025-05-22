package org.uniara.CustomerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniara.CustomerService.constant.Constant;
import org.uniara.CustomerService.model.Customer;
import org.uniara.CustomerService.service.CustomerService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(Constant.API_CUSTOMERS)
    public ResponseEntity<List<Customer>> findAll(/*@RequestHeader("Authorization") String token*/) {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping(Constant.API_CUSTOMERS)
    public ResponseEntity<Customer> save(/*@RequestHeader("Authorization") String token, */@RequestBody Customer customer) {
        if (customer.getCreatedAt() == null) {
            customer.setCreatedAt(new Date());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @PutMapping(Constant.API_CUSTOMERS)
    public ResponseEntity<Customer> update(/*@RequestHeader("Authorization") String token, */@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping(Constant.API_CUSTOMERS + "/{id}")
    public ResponseEntity<Optional<Customer>> findById(/*@RequestHeader("Authorization") String token, */@PathVariable("id") String id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping(Constant.API_CUSTOMERS + "/{id}")
    public ResponseEntity<Customer> deleteById(/*@RequestHeader("Authorization") String token, */@PathVariable("id") String id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
