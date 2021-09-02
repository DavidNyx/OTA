package com.example.ota.Attendance;

public class Attendance {
    private int SubID;
    private String SubName;
    private int Week1;
    private int Week2;
    private int Week3;
    private int Week4;
    private int Week5;
    private int Week6;
    private int Week7;
    private int Week8;
    private int Week9;
    private int Week10;

    public Attendance(int SubID, String SubName,int Week1,int Week2, int Week3, int Week4, int Week5, int Week6, int Week7, int Week8, int Week9, int Week10){
        this.SubID=SubID;
        this.SubName=SubName;
        this.Week1 = Week1;
        this.Week2 = Week2;
        this.Week3 = Week3;
        this.Week4 = Week4;
        this.Week5 = Week5;
        this.Week6 = Week6;
        this.Week7 = Week7;
        this.Week8 = Week8;
        this.Week9 = Week9;
        this.Week10 = Week10;
    }

    public int getSubID() {
        return SubID;
    }

    public void setSubID(int SubID) {
        this.SubID = SubID;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String SubName) {
        this.SubName = SubName;
    }

    public int getWeek1() {
        return Week1;
    }

    public void setWeek1(int Week1) {
        this.Week1 = Week1;
    }

    public int getWeek2() {
        return Week2;
    }

    public void setWeek2(int Week2) {
        this.Week2 = Week2;
    }

    public int getWeek3() {
        return Week3;
    }

    public void setWeek3(int Week3) {
        this.Week3 = Week3;
    }

    public int getWeek4() {
        return Week4;
    }

    public void setWeek4(int Week4) {
        this.Week4 = Week4;
    }

    public int getWeek5() {
        return Week5;
    }

    public void setWeek5(int Week5) {
        this.Week5 = Week5;
    }

    public int getWeek6() {
        return Week6;
    }

    public void setWeek6(int Week6) {
        this.Week6 = Week6;
    }

    public int getWeek7() {
        return Week7;
    }

    public void setWeek7(int Week7) {
        this.Week7 = Week7;
    }

    public int getWeek8() {
        return Week8;
    }

    public void setWeek8(int Week8) {
        this.Week8 = Week8;
    }

    public int getWeek9() {
        return Week9;
    }

    public void setWeek9(int Week9) { this.Week9 = Week9; }

    public int getWeek10() {
        return Week10;
    }

    public void setWeek10(int Week10) {
        this.Week10 = Week10;
    }
}
