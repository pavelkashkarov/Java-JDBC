package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.repository.ProductRepository;

import java.util.List;

@RestController
public class  ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Hebirnate Task.";
    }

    @GetMapping("/products/fetch-product")
    public List fetchProduct(@RequestParam String name) {
        return productRepository.findByName(name);
    }
}

