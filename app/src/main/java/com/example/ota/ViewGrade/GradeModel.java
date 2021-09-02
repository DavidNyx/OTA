package com.example.ota.ViewGrade;

public class GradeModel {
    private String StudentName;
    private double grade_15_1;
    private double grade_15_2;
    private double grade_15_3;
    private double grade_15_4;
    private double grade_45_1;
    private double grade_45_2;
    private double Midterm;
    private double Final;
    public GradeModel(String StudentName, double grade_15_1, double grade_15_2, double grade_15_3, double grade_15_4, double grade_45_1, double grade_45_2, double Midterm, double Final){
        this.StudentName=StudentName;
        this.grade_15_1=grade_15_1;
        this.grade_15_2=grade_15_2;
        this.grade_15_3=grade_15_3;
        this.grade_15_4=grade_15_4;
        this.grade_45_1=grade_45_1;
        this.grade_45_2=grade_45_2;
        this.Midterm=Midterm;
        this.Final=Final;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public double getGrade_15_1() {
        return grade_15_1;
    }

    public void setGrade_15_1(double grade_15_1) {
        this.grade_15_1 = grade_15_1;
    }

    public double getGrade_15_2() {
        return grade_15_2;
    }

    public void setGrade_15_2(double grade_15_2) {
        this.grade_15_2 = grade_15_2;
    }

    public double getGrade_15_3() {
        return grade_15_3;
    }

    public void setGrade_15_3(double grade_15_3) {
        this.grade_15_3 = grade_15_3;
    }

    public double getGrade_15_4() {
        return grade_15_4;
    }

    public void setGrade_15_4(double grade_15_4) {
        this.grade_15_4 = grade_15_4;
    }

    public double getGrade_45_1() {
        return grade_45_1;
    }

    public void setGrade_45_1(double grade_45_1) {
        this.grade_45_1 = grade_45_1;
    }

    public double getGrade_45_2() {
        return grade_45_2;
    }

    public void setGrade_45_2(double grade_45_2) {
        this.grade_45_2 = grade_45_2;
    }

    public double getMidterm() {
        return Midterm;
    }

    public void setMidterm(double midterm) {
        Midterm = midterm;
    }

    public double getFinal() {
        return Final;
    }

    public void setFinal(double aFinal) {
        Final = aFinal;
    }
}
