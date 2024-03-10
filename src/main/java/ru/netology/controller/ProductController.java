package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.repository.ProductRepository;

@RestController
public class  ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to JDBC Task.";
    }

    @GetMapping("/products/fetch-product")
    public String fetchProduct(@RequestParam(value = "name", defaultValue = "Petya") String name) {
        return productRepository.getProductName(name);
    }
}

