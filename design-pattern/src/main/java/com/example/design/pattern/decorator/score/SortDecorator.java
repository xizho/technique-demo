package com.example.design.pattern.decorator.score;

public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportScore() {
        System.out.println("我的排名是35");
    }

    @Override
    public void report() {
        super.report();
        reportScore();
    }
}
