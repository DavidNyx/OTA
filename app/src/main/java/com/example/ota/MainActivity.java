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
    private String url = "https://ota-be-server.herokuapp.com/linkserver/account/login";

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
                Toast.makeText(MainActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("a",data.toString());
            final String url = "https://ota-be-server.herokuapp.com";///account/login
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, data,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                                try {
                                    Log.d("b",response.toString());
                                    String message=response.getString("message");
                                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                    if(message == "Login successfully") { // moi sua
                                        String ID = response.getString("ID");
                                        Account.account.setID(ID);
                                        String password = response.getString("password");
                                        Toast.makeText(MainActivity.this, Account.account.getID(), Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this, test.class));
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
                    //Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
        }

    }

    public void onClickForgotPassword(View view){
        Toast.makeText(this, "Test for new password", Toast.LENGTH_SHORT).show();
    }
}