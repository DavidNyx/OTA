package com.example.ota;

public class Attendance {
    private int SubID;
    private String SubName;
    private boolean Week1;
    private boolean Week2;
    private boolean Week3;
    private boolean Week4;
    private boolean Week5;
    private boolean Week6;
    private boolean Week7;
    private boolean Week8;
    private boolean Week9;
    private boolean Week10;

    public Attendance(int SubID, String SubName,boolean Week1,boolean Week2, boolean Week3, boolean Week4, boolean Week5, boolean Week6, boolean Week7, boolean Week8, boolean Week9, boolean Week10){
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

    public boolean getWeek1() {
        return Week1;
    }

    public void setWeek1(boolean Week1) {
        this.Week1 = Week1;
    }

    public boolean getWeek2() {
        return Week2;
    }

    public void setWeek2(boolean Week2) {
        this.Week2 = Week2;
    }

    public boolean getWeek3() {
        return Week3;
    }

    public void setWeek3(boolean Week3) {
        this.Week3 = Week3;
    }

    public boolean getWeek4() {
        return Week4;
    }

    public void setWeek4(boolean Week4) {
        this.Week4 = Week4;
    }

    public boolean getWeek5() {
        return Week5;
    }

    public void setWeek5(boolean Week5) {
        this.Week5 = Week5;
    }

    public boolean getWeek6() {
        return Week6;
    }

    public void setWeek6(boolean Week6) {
        this.Week6 = Week6;
    }

    public boolean getWeek7() {
        return Week7;
    }

    public void setWeek7(boolean Week7) {
        this.Week7 = Week7;
    }

    public boolean getWeek8() {
        return Week8;
    }

    public void setWeek8(boolean Week8) {
        this.Week8 = Week8;
    }

    public boolean getWeek9() {
        return Week9;
    }

    public void setWeek9(boolean Week9) { this.Week9 = Week9; }

    public boolean getWeek10() {
        return Week10;
    }

    public void setWeek10(boolean Week10) {
        this.Week10 = Week10;
    }
}
