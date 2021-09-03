package com.example.ota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_attendance);
    }
    public void EA_Submit(View view){
        EditText EA_ID = findViewById(R.id.EA_ID);
        EditText EA_Subject = findViewById(R.id.EA_Subject);
        EditText EA_Week1 = findViewById(R.id.EA_Week1);
        EditText EA_Week2 = findViewById(R.id.EA_Week2);
        EditText EA_Week3 = findViewById(R.id.EA_Week3);
        EditText EA_Week4 = findViewById(R.id.EA_Week4);
        EditText EA_Week5 = findViewById(R.id.EA_Week5);
        EditText EA_Week6 = findViewById(R.id.EA_Week6);
        EditText EA_Week7 = findViewById(R.id.EA_Week7);
        EditText EA_Week8 = findViewById(R.id.EA_Week8);
        EditText EA_Week9 = findViewById(R.id.EA_Week9);
        EditText EA_Week10 = findViewById(R.id.EA_Week10);
        if (EA_ID.getText().toString().equals("") || EA_Subject.getText().toString().equals(""))
        {
            Toast.makeText(this, "Missing Student ID or Subject, please try again", Toast.LENGTH_SHORT).show();
        }
        else {
            JSONObject data = new JSONObject();
            try { // day la data truyen cho server
                data.put("TeacherID", Account.account.getID());
                data.put("subjectName", EA_Subject.getText().toString());
                data.put("StudentID", EA_ID.getText().toString());
                data.put("Week1", check(EA_Week1));
                data.put("Week2", check(EA_Week2));
                data.put("Week3", check(EA_Week3));
                data.put("Week4", check(EA_Week4));
                data.put("Week5", check(EA_Week5));
                data.put("Week6", check(EA_Week6));
                data.put("Week7", check(EA_Week7));
                data.put("Week8", check(EA_Week8));
                data.put("Week9", check(EA_Week9));
                data.put("Week10", check(EA_Week10));
                Log.d("h", data.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final String url = "https://ota-be-server.herokuapp.com/teachers/editattendance/";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d("b", response.toString());
                                String message = response.getString("message");
                                Toast.makeText(EditAttendance.this, message, Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(EditAttendance.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
            VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
        }
    }

    public int check(EditText text){
        if(text.getText().toString().equals("")==true)
            return -1;
        if(text.getText().toString().equals("1") == true)
            return 1;
        else if(text.getText().toString().equals("0") == true)
            return 0;
        else
            return -1;
    }
}