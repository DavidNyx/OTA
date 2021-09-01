package com.example.ota;

public class score {
    private int SubId;
    private String SubName;
    private int grade_15_1;
    private int grade_15_2;
    private int grade_15_3;
    private int grade_15_4;
    private int grade_45_1;
    private int grade_45_2;
    private int giuaki;
    private int cuoiki;
    public score(int SubId,String SubName, int grade_15_1, int grade_15_2, int grade_15_3, int grade_15_4, int grade_45_1, int grade_45_2, int giuaki, int cuoiki){
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

    public int getGiuaki() {
        return giuaki;
    }

    public void setGiuaki(int giuaki) {
        this.giuaki = giuaki;
    }

    public int getCuoiki() {
        return cuoiki;
    }

    public void setCuoiki(int cuoiki) {
        this.cuoiki = cuoiki;
    }
}
