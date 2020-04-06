package com.example.design.pattern.decorator.simple;

public class SugarFouthGradeSchoolReport extends FouthGradeSchoolReport {
    private void reportHighScore() {
        System.out.println("这次考试，语文最高分：73，数学：77，自然：81");
    }

    private void reportScore() {
        System.out.println("我的排名是35");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
        this.reportScore();
    }
}
