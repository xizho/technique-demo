package com.example.design.pattern.decorator.score;

public class FatherMain {

    public static void main(String[] args) {
        SchoolReport schoolReport;
        schoolReport = new FouthGradeSchoolReport();
        schoolReport = new HighSchoolDecorator(schoolReport);
        schoolReport = new SortDecorator(schoolReport);
        schoolReport.report();
        schoolReport.sign("还是你爸爸");
    }

}
