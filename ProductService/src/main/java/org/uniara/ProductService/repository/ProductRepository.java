package org.uniara.ProductService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.uniara.ProductService.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
