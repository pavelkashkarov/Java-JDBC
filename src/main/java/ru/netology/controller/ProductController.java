package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.repository.ProductRepository;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to JDBC Task.";
    }

    @GetMapping("/products/fetch-product")
    public List<Map<String, Object>> fetchProduct(@RequestParam(value = "name", defaultValue = "Petya") String name) {
        return productRepository.getProductName(name);
    }
}

