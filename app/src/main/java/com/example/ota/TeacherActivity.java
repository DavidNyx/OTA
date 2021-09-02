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

import com.example.ota.Fee.NotificationActivity;
import com.example.ota.ViewGrade.ViewGrade;

public class TeacherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        getSupportActionBar().setTitle(R.string.Teacher);
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
        startActivity(new Intent(TeacherActivity.this, MainActivity.class));
    }

    public void onClickAttendance(View view){
        startActivity(new Intent(TeacherActivity.this, AttendanceMenu.class));
    }
    public void ViewGradeButton(View view){
        startActivity(new Intent(TeacherActivity.this, ViewGrade.class));
    }
    public void EditGradeButton(View view){
        startActivity(new Intent(TeacherActivity.this, EditGrade.class));
    }
    public void onClickNotification(View view){
        startActivity(new Intent(TeacherActivity.this, NotificationActivity.class));
    }
}