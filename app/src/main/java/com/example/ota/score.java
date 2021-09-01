package com.example.ota;

public class Score {
    int SubId;
    String SubName;
    int grade_15_1;
    int grade_15_2;
    int grade_15_3;
    int grade_15_4;
    int grade_45_1;
    int grade_45_2;
    int Midterm;
    int Final;
    public Score(int SubId,String SubName, int grade_15_1, int grade_15_2, int grade_15_3, int grade_15_4, int grade_45_1, int grade_45_2, int Midterm, int Final){
        this.SubId=SubId;
        this.SubName=SubName;
        this.grade_15_1=grade_15_1;
        this.grade_15_2=grade_15_2;
        this.grade_15_3=grade_15_3;
        this.grade_15_4=grade_15_4;
        this.grade_45_1=grade_45_1;
        this.grade_45_2=grade_45_2;
        this.Midterm=Midterm;
        this.Final=Final;
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

    public int getGrade_15_1() {
        return grade_15_1;
    }

    public void setGrade_15_1(int grade_15_1) {
        this.grade_15_1 = grade_15_1;
    }

    public int getGrade_15_2() {
        return grade_15_2;
    }

    public void setGrade_15_2(int grade_15_2) {
        this.grade_15_2 = grade_15_2;
    }

    public int getGrade_15_3() {
        return grade_15_3;
    }

    public void setGrade_15_3(int grade_15_3) {
        this.grade_15_3 = grade_15_3;
    }

    public int getGrade_15_4() {
        return grade_15_4;
    }

    public void setGrade_15_4(int grade_15_4) {
        this.grade_15_4 = grade_15_4;
    }

    public int getGrade_45_1() {
        return grade_45_1;
    }

    public void setGrade_45_1(int grade_45_1) {
        this.grade_45_1 = grade_45_1;
    }

    public int getGrade_45_2() {
        return grade_45_2;
    }

    public void setGrade_45_2(int grade_45_2) {
        this.grade_45_2 = grade_45_2;
    }

    public int getMidterm() {
        return Midterm;
    }

    public void setMidterm(int Midterm) {
        this.Midterm = Midterm;
    }

    public int getFinal() {
        return Final;
    }

    public void setFinal(int Final) {
        this.Final = Final;
    }
}
