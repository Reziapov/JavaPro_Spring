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
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;


    @Autowired
    private OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }


    @GetMapping
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable int id) {
        return this.orderService.getOrderById(id);
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @PostMapping("/{orderId}/products")
    public void addProductToOrder(@PathVariable int orderId, @RequestBody Product product) {
        orderService.addProductToOrder(orderId, product);
    }

}
