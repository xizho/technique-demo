package com.example.design.pattern.decorator.component;

public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    private void method2() {
        System.out.println("装饰2");
    }

    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
