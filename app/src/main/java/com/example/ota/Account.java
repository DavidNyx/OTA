package com.example.ota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Account extends AppCompatActivity {
    final public static Account account=new Account();
    protected String ID;
    protected String Name;
    protected String Class;
    protected String Birthday;
    protected String Email;
    protected String Address;
    protected String ID_Student;
    protected String Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getclass() {
        return Class;
    }

    public void setClass(String aClass) {
        Class = aClass;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getID_Student() {
        return ID_Student;
    }

    public void setID_Student(String ID_Student) {
        this.ID_Student = ID_Student;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getHeader(){
        if(this.ID.substring(0,2).equals("SD"))
            return "stuID";
        if(this.ID.substring(0,2).equals("PR"))
            return "paID";
        if(this.ID.substring(0,2).equals("TC"))
            return "tcID";
        if(this.ID.substring(0,2).equals("AD"))
            return "adID";
        return null;
    }

    public String getURL() {
        if (this.ID.substring(0, 2).equals("SD"))
            return "https://ota-be-server.herokuapp.com/students/";
        if (this.ID.substring(0, 2).equals("PR"))
            return "https://ota-be-server.herokuapp.com/parents/";
        if (this.ID.substring(0, 2).equals("TC"))
            return "https://ota-be-server.herokuapp.com/teachers/";
        if (this.ID.substring(0, 2).equals("AD"))
            return "https://ota-be-server.herokuapp.com/admin/";
        return null;
    }
}