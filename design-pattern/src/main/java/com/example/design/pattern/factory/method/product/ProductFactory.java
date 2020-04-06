package com.example.design.pattern.factory.method.product;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    private static final Map<String, Product> productMap = new HashMap<>();

    public static synchronized Product createProduct(String type) {
        Product product = null;
        if (productMap.containsKey(type)) {
            return productMap.get(type);
        } else {
            if ("Product1".equals(type)) {
                product = new ConcreteProduct1();
            } else if ("Product2".equals(type)) {
                product = new ConcreteProduct2();
            }

            productMap.put(type, product);
        }

        return product;
    }
}
