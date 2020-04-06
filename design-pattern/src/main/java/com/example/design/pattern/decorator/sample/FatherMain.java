package com.example.design.pattern.decorator.sample;

public class FatherMain {
    public static void main(String[] args) {
        SchoolReport schoolReport = new FouthGradeSchoolReport();
        schoolReport.report();
        schoolReport.sign("你爸爸");
    }
}
