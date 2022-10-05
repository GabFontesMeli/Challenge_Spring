package com.example.challenge_spring.controller;

import com.example.challenge_spring.dto.ProductDto;
import com.example.challenge_spring.model.Product;
import com.example.challenge_spring.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    private IProduct service;
    @PostMapping("/insert-articles-request")
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product) throws IOException {
        System.out.println(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(product));
    }
}