package com.example.javapro_spring.controller;

import com.example.javapro_spring.model.Order;
import com.example.javapro_spring.model.Product;
import com.example.javapro_spring.service.OrderService;
import com.example.javapro_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @Autowired
    private ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllOrders() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getOrderById(@PathVariable int id) {
        return this.productService.getProductById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}
