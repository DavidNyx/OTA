package com.example.ota.Grade;

public class score {
    private int SubId;
    private String SubName;
    private double grade_15_1;
    private double grade_15_2;
    private double grade_15_3;
    private double grade_15_4;
    private double grade_45_1;
    private double grade_45_2;
    private double giuaki;
    private double cuoiki;
    public score(int SubId,String SubName, double grade_15_1, double grade_15_2, double grade_15_3, double grade_15_4, double grade_45_1, double grade_45_2, double giuaki, double cuoiki){
        this.SubId=SubId;
        this.SubName=SubName;
        this.grade_15_1=grade_15_1;
        this.grade_15_2=grade_15_2;
        this.grade_15_3=grade_15_3;
        this.grade_15_4=grade_15_4;
        this.grade_45_1=grade_45_1;
        this.grade_45_2=grade_45_2;
        this.giuaki=giuaki;
        this.cuoiki=cuoiki;
    }

    public int getSubId() {
        return SubId;
    }

    public void setSubId(int subId) {
        SubId = subId;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
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

    public double getGiuaki() {
        return giuaki;
    }

    public void setGiuaki(double giuaki) {
        this.giuaki = giuaki;
    }

    public double getCuoiki() {
        return cuoiki;
    }

    public void setCuoiki(double cuoiki) {
        this.cuoiki = cuoiki;
    }
}
