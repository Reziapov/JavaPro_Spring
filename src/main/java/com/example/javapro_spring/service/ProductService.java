package com.example.javapro_spring.service;


import com.example.javapro_spring.model.Order;
import com.example.javapro_spring.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public List<Product> products = List.of(
            Product.builder().id(11).name("watermelon").cost(15.55).build(),
            Product.builder().id(12).name("cheese").cost(21.55).build(),
            Product.builder().id(13).name("apple").cost(10.33).build(),
            Product.builder().id(14).name("potato").cost(9.99).build(),
            Product.builder().id(15).name("tomato").cost(12.01).build(),
            Product.builder().id(16).name("orange").cost(15.99).build()
    );

    public List<Product> getAllProducts(){
        return products;
    }

    public Optional<Product> getProductById(int id){
        return products.stream()
                .filter(order -> order.getId() == id)
                .findFirst();
    }

    public void addProduct(Product product){
        products.add(product);
    }

}
