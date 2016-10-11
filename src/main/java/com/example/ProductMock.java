package com.example;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductMock {

    public static List<Product> getAll(){
        return Stream.generate(() -> new Product(String.valueOf(Math.random()),String.valueOf(Math.random())))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static Product save(Product product){
        product.setId(String.valueOf(Math.random() * 100));
        return product;
    }

}
