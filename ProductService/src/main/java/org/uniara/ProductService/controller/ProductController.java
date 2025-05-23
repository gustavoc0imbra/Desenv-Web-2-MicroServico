package org.uniara.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniara.ProductService.DTO.CreateProductDTO;
import org.uniara.ProductService.DTO.UpdateProductDTO;
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
    public ResponseEntity<Product> save(/*@RequestHeader("Authorization") String token, */@RequestBody CreateProductDTO dto) {
        Product product = new Product();

        if (product.getCreatedAt() == null) {
            product.setCreatedAt(new Date());
        }

        if (!product.isAvailable()) {
            product.setAvailable(false);
        }

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping(Constant.API_PRODUCTS)
    public ResponseEntity<Product> update(/*@RequestHeader("Authorization") String token, */@RequestBody UpdateProductDTO dto) {
        Optional<Product> product = productService.findById(dto.getId());

        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        product.get().setName(dto.getName());
        product.get().setDescription(dto.getDescription());
        product.get().setPrice(dto.getPrice());
        product.get().setAvailable(dto.getIsAvailable());

        return ResponseEntity.ok(productService.save(product.get()));
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
