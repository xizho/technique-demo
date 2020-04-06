package com.example.design.pattern.decorator.score;

public class HighSchoolDecorator extends Decorator {

    public HighSchoolDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportHighScore() {
        System.out.println("这次考试，语文最高分：73，数学：77，自然：81");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
