package com.example.design.pattern.prototype.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Thing implements Cloneable {
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected Thing clone() throws CloneNotSupportedException {
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return thing;
    }

    public void setValue(String value) {
        this.arrayList.add(value);
    }

    public ArrayList<String> getValues() {
        return this.arrayList;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Thing thing = new Thing();
        thing.setValue("张三");
        Thing cloneThing = thing.clone();
        cloneThing.setValue("李四");
        System.out.println(thing.getValues()); // [张三, 李四]，浅拷贝，对象、数组不拷贝
        System.out.println(cloneThing.getValues()); // [张三, 李四]，浅拷贝，对象、数组不拷贝
        System.out.println(thing.arrayList == cloneThing.arrayList); //true，同一个对象
    }
}
