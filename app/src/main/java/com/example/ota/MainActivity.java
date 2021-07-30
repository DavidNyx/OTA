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
        {
            System.out.println("empty");
            Toast.makeText(this, "Missing username or password, please try again", Toast.LENGTH_SHORT).show();
        }
        else
        {
            System.out.println(editUsername.getText().toString());
            System.out.println(editPassword.getText().toString());
            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Parent_Menu.class);
            startActivity(intent);
        }

    }

    public void onClickForgotPassword(View view){
        Toast.makeText(this, "Test for new password", Toast.LENGTH_SHORT).show();
    }
}