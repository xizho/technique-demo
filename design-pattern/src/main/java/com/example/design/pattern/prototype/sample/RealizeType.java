package com.example.design.pattern.prototype.sample;

/**
 * 原型模式：
 * 浅克隆：只复制值和引用，不复制对象
 */
public class RealizeType implements Cloneable {

    public RealizeType() {
        System.out.println("构造：原型创建成功");
    }

    @Override
    protected RealizeType clone() throws CloneNotSupportedException {
        System.out.println("原型复制成功！");
        return (RealizeType) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType r1 = new RealizeType();
        RealizeType r2 = r1.clone();
        System.out.println("是否同一个对象：" + (r1 == r2));
    }

}
