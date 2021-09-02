package com.example.ota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ota.Attendance.AttendanceActivity;
import com.example.ota.Fee.FeeActivity;
import com.example.ota.Fee.NotificationActivity;
import com.example.ota.Grade.grade;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuItem;

public class StudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        getSupportActionBar().setTitle(R.string.Student);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e600ff")));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.setting:
                break;
            case R.id.account:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClickGradeofStudent(View view){
        startActivity(new Intent(StudentActivity.this, grade.class));
    }
    public void onClickFeeStudent(View view){
        startActivity(new Intent(StudentActivity.this, FeeActivity.class));
    }
    public void onClickAttendance(View view){
        startActivity(new Intent(StudentActivity.this, AttendanceActivity.class));
    }
    public void onClickLogout(View view){
        Toast.makeText(this, R.string.logOutSuccess, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(StudentActivity.this, MainActivity.class));
    }
    public void onClickViewSchedule(View view){
        startActivity(new Intent(StudentActivity.this, schedule.class));
    }
    public void onClickNotification(View view){
        startActivity(new Intent(StudentActivity.this, NotificationActivity.class));
    }
}