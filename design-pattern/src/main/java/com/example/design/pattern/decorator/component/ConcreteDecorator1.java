package com.example.design.pattern.decorator.component;

public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    private void method1() {
        System.out.println("装饰1");
    }

    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
