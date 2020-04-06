package com.example.design.pattern.factory.method.product;

public class CreateProudctMain {

    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product1 = creator.createProduct(ConcreteProduct1.class);
        product1.method1();
        product1.method2();

        Product product2 = creator.createProduct(ConcreteProduct2.class);
        product2.method1();
        product2.method2();
    }
}
