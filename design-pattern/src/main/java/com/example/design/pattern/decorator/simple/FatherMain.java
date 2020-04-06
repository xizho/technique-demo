package com.example.design.pattern.decorator.simple;


public class FatherMain {
    public static void main(String[] args) {
        SchoolReport schoolReport = new SugarFouthGradeSchoolReport();
        schoolReport.report();
        schoolReport.sign("你爸爸");
    }
}
