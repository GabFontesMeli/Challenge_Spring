package com.example.challenge_spring.repository;

import com.example.challenge_spring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepo {
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

    // Método que acessa a lista, mapeia os produtos e adiciona um produto a lista.
    public Product saveProduct(Product product) throws IOException {
        List<Product> products = getAll();
        products = new ArrayList<>(products);
        products.add(product);
        try{
            writer.writeValue(new File(linkFile), products);
        } catch (IOException e){
            throw new IOException("Falha ao acessar o arquivo");
        }
        return product;
    }

    public List<Product> saveProducts(List<Product> newProducts) throws IOException { // newProduct é lista de novos produtos a serem cadastrados
        List<Product> products = getAll();
        products = new ArrayList<>(products);
        products.addAll(newProducts); // Salvando uma lista de novos produtos dentro da lista que ja existe
        try{
            writer.writeValue(new File(linkFile), products);
        } catch (IOException e){
            throw new IOException("Falha ao acessar o arquivo");
        }
        return newProducts;
    }

    // Método que retorna a lista de produtos do arquivo.json
    public List<Product> getAll(){
        List<Product> products = null;
        try {
            products = Arrays.asList(mapper.readValue(new File(linkFile), Product[].class));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return products;
    }
}
