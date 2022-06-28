package com.quarkus.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quarkus.dev.entities.Product;
import com.quarkus.dev.repositories.ProductJPARepository;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private ProductJPARepository productRepository;

    public ProductController(ProductJPARepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> fruits(@RequestParam("name") String name) {
        if (name != null) {
            return productRepository.findByName(name);
        }
        return productRepository.findAll();
    }

}