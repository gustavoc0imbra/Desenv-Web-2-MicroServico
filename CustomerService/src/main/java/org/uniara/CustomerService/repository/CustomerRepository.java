package org.uniara.CustomerService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.uniara.CustomerService.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
