package com.example.challenge_spring.service;

import com.example.challenge_spring.dto.ProductDto;
import com.example.challenge_spring.model.Product;

import java.io.IOException;
import java.util.List;

public interface IProduct {
    ProductDto createProduct(Product product) throws IOException;
    List<ProductDto> createProducts(List<Product> products) throws IOException;
    List<Product> getAll();
    List<Product> getAllByCategory(String category);
    List<Product> getAllByCategoryAndShipping(String category, boolean freeShipping);
    List<Product> getAllByShippingAndPrestige(boolean freeShipping, String prestige);
}
