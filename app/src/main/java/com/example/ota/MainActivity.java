package com.example.ota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogin(View view){

        EditText editUsername = findViewById(R.id.editUsername);
        EditText editPassword = findViewById(R.id.editPassword);
        if (editUsername.getText().toString().equals("") || editPassword.getText().toString().equals(""))
            Toast.makeText(this, R.string.logInFail, Toast.LENGTH_SHORT).show();
        else
        {
            System.out.println(editUsername.getText().toString());
            System.out.println(editPassword.getText().toString());
            Toast.makeText(this, R.string.logInSuccess, Toast.LENGTH_SHORT).show();

            if (editUsername.getText().toString().equals("student"))
                startActivity(new Intent(MainActivity.this, StudentActivity.class));

            if (editUsername.getText().toString().equals("parents"))
                startActivity(new Intent(MainActivity.this, ParentsActivity.class));

            if (editUsername.getText().toString().equals("administrator"))
                startActivity(new Intent(MainActivity.this, AdministratorActivity.class));

            if (editUsername.getText().toString().equals("teacher"))
                startActivity(new Intent(MainActivity.this, TeacherActivity.class));
        }


    }

    public void onClickForgotPassword(View view){
        Toast.makeText(this, "Test for new password", Toast.LENGTH_SHORT).show();
    }
}