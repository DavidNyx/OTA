package com.example.ota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String url = "https://ota-be-server.herokuapp.com/linkserver/account/login/";

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
        else {
            String Username = editUsername.getText().toString();
            String Password = editPassword.getText().toString();
            JSONObject data = null;
            data = new JSONObject();
            try { // day la data truyen cho server
                data.put("ID",Username);
                data.put("password",Password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final String url = "https://ota-be-server.herokuapp.com/account/login/";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d("b",response.toString());
                                String message=response.getString("message");
                                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                if(message.equals("Login successfully")) { // moi sua
                                    JSONObject id_password=(JSONObject) response.get("id_password");
                                    String id = id_password.getString("id");
                                    Account.account.setID(id);
                                    String Password = id_password.getString("Password");
                                    Toast.makeText(MainActivity.this, Account.account.getID()+" "+Password, Toast.LENGTH_SHORT).show();
                                    if(Username.substring(0,2).equals("SD"))
                                        startActivity(new Intent(MainActivity.this, StudentActivity.class));
                                    if(Username.substring(0,2).equals("PR"))
                                        startActivity(new Intent(MainActivity.this, ParentsActivity.class));
                                    if(Username.substring(0,2).equals("TC"))
                                        startActivity(new Intent(MainActivity.this, TeacherActivity.class));
                                    if(Username.substring(0,2).equals("AD"))
                                        startActivity(new Intent(MainActivity.this, AdministratorActivity.class));
                                }
                            }catch(JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        //}
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String message=error.toString();
                    Log.d("c",message);
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
        }

    }

    public void onClickForgotPassword(View view){
        Toast.makeText(this, "Test for new password", Toast.LENGTH_SHORT).show();
    }
}