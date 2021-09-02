package com.example.ota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ota.Grade.grade;

public class ParentsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents);
        getSupportActionBar().setTitle(R.string.Parents);
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
    public void onClickLogout(View view){
        Toast.makeText(this, R.string.logOutSuccess, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ParentsActivity.this, MainActivity.class));
    }
    public void onClickGrade(View view){
        startActivity(new Intent(ParentsActivity.this, grade.class));
    }
    public void onClickAbsentLetter(View view){
        startActivity(new Intent(ParentsActivity.this, Email.class));
    }
    public void onClickAttendance(View view){
        startActivity(new Intent(ParentsActivity.this, AttendanceActivity.class));
    }
    public void onClickViewSchedule(View view){
        startActivity(new Intent(ParentsActivity.this, schedule.class));
    }
}