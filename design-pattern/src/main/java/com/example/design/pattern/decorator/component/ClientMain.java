package com.example.design.pattern.decorator.component;

public class ClientMain {
    public static void main(String[] args) {
        Component concreteComponent = new ConcreteComponent();
        concreteComponent = new ConcreteDecorator1(concreteComponent);
        concreteComponent = new ConcreteDecorator2(concreteComponent);
        concreteComponent.operate();
    }
}
