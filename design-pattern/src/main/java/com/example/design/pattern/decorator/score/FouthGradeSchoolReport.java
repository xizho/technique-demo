package com.example.design.pattern.decorator.score;

public class FouthGradeSchoolReport extends SchoolReport {
    @Override
    public void report() {
        System.out.println("尊敬的***家长：");
        System.out.println("。。。。。。。");
        System.out.println("。。。。。。。");
        System.out.println("。。。。。。。");
        System.out.println(" 语文：63\t数学：65\t体育：98\t自然：70\t");
        System.out.println("。。。。。。。");
        System.out.println("。。。。。。。");
        System.out.println("。。。。。。。");
        System.out.println("            家长签名：           ");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名：" + name);
    }
}
