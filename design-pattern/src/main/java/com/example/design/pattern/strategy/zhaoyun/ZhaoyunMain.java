package com.example.design.pattern.strategy.zhaoyun;

public class ZhaoyunMain {
    public static void main(String[] args) {
        Context context;
        System.out.println("刚到吴国的时候拆开第一个");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println();
        System.out.println("刘备乐不思蜀了，拆开第二个");
        context = new Context(new GivenGreenLight());
        context.operate();
        System.out.println();
        System.out.println("孙权的追兵来了，拆开第三个");
        context = new Context(new BlockEnemy());
        context.operate();
    }
}
