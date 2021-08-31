package com.example.ota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }

    public void onClickAttendance(View view){
        Toast.makeText(this, "Attendance successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(TeacherActivity.this, AttendanceActivity.class));
    }
}