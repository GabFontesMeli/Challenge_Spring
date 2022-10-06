package com.example.challenge_spring.controller;

import com.example.challenge_spring.dto.ProductDto;
import com.example.challenge_spring.model.Product;
import com.example.challenge_spring.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    private IProduct service;

    @PostMapping("/insert-article-request")
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product) throws IOException {
        System.out.println(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(product));
    }

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProductDto>> createProducts(@RequestBody List<Product> products) throws IOException {
        System.out.println(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProducts(products));
    }

    @GetMapping(value = "/articles")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping(value = "/articles", params = { "category" })
    public ResponseEntity<List<Product>> getAll(@RequestParam String category) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllByCategory(category));
    }

    @GetMapping(value = "/articles", params = { "category", "freeShipping" })
    public ResponseEntity<List<Product>> getAll(@RequestParam String category, @RequestParam boolean freeShipping) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllByCategoryAndShipping(category, freeShipping));
    }

    @GetMapping(value = "/articles", params = { "freeShipping", "prestige" })
    public ResponseEntity<List<Product>> getAll(@RequestParam boolean freeShipping, @RequestParam String prestige) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllByShippingAndPrestige(freeShipping, prestige));
    }
}