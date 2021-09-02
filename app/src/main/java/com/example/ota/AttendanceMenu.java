package com.example.ota;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ota.Attendance.AttendanceActivity;


public class AttendanceMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_menu);
        getSupportActionBar().setTitle(R.string.Attendance);
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

    public void onClickViewAttendance(View view){
        startActivity(new Intent(AttendanceMenu.this, AttendanceActivity.class));
    }

    public void onClickEditAttendance(View view){
        startActivity(new Intent(AttendanceMenu.this, EditAttendance.class));
    }

}
