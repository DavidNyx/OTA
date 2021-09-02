package com.example.ota.ViewAttendance;

public class AttendanceModel {
    private String StudentID;
    private String StudentName;
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

    public AttendanceModel(String StudentID, String StudentName, int Week1, int Week2, int Week3, int Week4, int Week5, int Week6, int Week7, int Week8, int Week9, int Week10){
        this.StudentID=StudentID;
        this.StudentName=StudentName;
        this.Week1=Week1;
        this.Week2=Week2;
        this.Week3=Week3;
        this.Week4=Week4;
        this.Week5=Week5;
        this.Week6=Week6;
        this.Week7=Week7;
        this.Week8=Week8;
        this.Week9=Week9;
        this.Week10=Week10;
    }

    public String getStudentID() { return StudentID; }

    public void setStudentID(String studentID) { StudentID = studentID; }

    public String getStudentName() { return StudentName; }

    public void setStudentName(String studentName) { StudentName = studentName; }

    public int getWeek1(){ return Week1; };

    public void setWeek1(int week1) { Week1 = week1; }

    public int getWeek2(){ return Week2; };

    public void setWeek2(int week2) { Week2 = week2; }

    public int getWeek3(){ return Week3; };

    public void setWeek3(int week3) { Week3 = week3; }

    public int getWeek4(){ return Week4; };

    public void setWeek4(int week4) { Week4 = week4; }

    public int getWeek5(){ return Week5; };

    public void setWeek5(int week5) { Week5 = week5; }

    public int getWeek6(){ return Week6; };

    public void setWeek6(int week6) { Week6 = week6; }

    public int getWeek7(){ return Week7; };

    public void setWeek7(int week7) { Week7 = week7; }

    public int getWeek8(){ return Week8; }

    public void setWeek8(int week8) { Week8 = week8; }

    public int getWeek9(){ return Week9; }

    public void setWeek9(int week9) { Week9 = week9; }

    public int getWeek10(){ return Week10; }

    public void setWeek10(int week10) { Week10 = week10; }

}
