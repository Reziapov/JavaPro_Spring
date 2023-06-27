package com.example.javapro_spring.service;


import com.example.javapro_spring.model.Order;
import com.example.javapro_spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final List<Order> orders;
    public ProductService productService;


    @Autowired
    public OrderService(ProductService productService) {
        this.productService = productService;
        this.orders = List.of(
                Order.builder().id(1).productList(productService.products).date(LocalDate.now()).build(),
                Order.builder().id(1).productList(productService.products).date(LocalDate.now()).build(),
                Order.builder().id(3).productList(productService.products).date(LocalDate.now()).build(),
                Order.builder().id(4).productList(productService.products).date(LocalDate.now()).build(),
                Order.builder().id(5).productList(productService.products).date(LocalDate.now()).build(),
                Order.builder().id(6).productList(productService.products).date(LocalDate.now()).build()
        );
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Optional<Order> getOrderById(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addProductToOrder(int orderId, Product product) {
        Optional<Order> optionalOrder = getOrderById(orderId);
        optionalOrder.ifPresent(order -> order.getProductList().add(product));
    }
}
