package org.uniara.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniara.ProductService.constant.Constant;
import org.uniara.ProductService.model.Product;
import org.uniara.ProductService.service.ProductService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(Constant.API_PRODUCTS)
    public ResponseEntity<List<Product>> findAll(/*@RequestHeader("Authorization") String token*/) {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping(Constant.API_PRODUCTS)
    public ResponseEntity<Product> save(/*@RequestHeader("Authorization") String token, */@RequestBody Product product) {
        if (product.getCreatedAt() == null) {
            product.setCreatedAt(new Date());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping(Constant.API_PRODUCTS)
    public ResponseEntity<Product> update(/*@RequestHeader("Authorization") String token, */@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping(Constant.API_PRODUCTS + "/{id}")
    public ResponseEntity<Optional<Product>> findById(/*@RequestHeader("Authorization") String token, */@PathVariable("id") String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping(Constant.API_PRODUCTS + "/{id}")
    public ResponseEntity<Product> deleteById(/*@RequestHeader("Authorization") String token, */@PathVariable("id") String id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
