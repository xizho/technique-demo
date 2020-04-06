package com.example.design.pattern.prototype.simple;

import com.example.design.pattern.prototype.sample.Client;
import com.example.design.pattern.prototype.sample.ConcretePrototypeA;

import java.util.ArrayList;
import java.util.List;

public class ConcretePrototypeATest {

    public static void main(String[] args) {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(28);
        concretePrototype.setName("Tom");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Ball");
        concretePrototype.setHobbies(hobbies);

        Client client = new Client();
        ConcretePrototypeA concretePrototype2 = (ConcretePrototypeA) client.startClone(concretePrototype);

        System.out.println("对象地址比较：" + (concretePrototype.getHobbies() == concretePrototype2.getHobbies()));
    }

}