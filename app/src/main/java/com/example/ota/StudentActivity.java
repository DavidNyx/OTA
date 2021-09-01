package com.example.ota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        getSupportActionBar().setTitle(R.string.Student);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e600ff")));
    }

    public void onClickViewSchedule(View view) {

        setContentView(R.layout.schedule);
        JSONObject data = null;
        data = new JSONObject();
        try {
            data.put("stuID", Account.account.getID());
            //Toast.makeText(StudentActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("a",data.toString());
        final String url = "https://ota-be-server.herokuapp.com/students/timetable/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("b",response.toString());
                            String message=response.getString("message");
                            Toast.makeText(StudentActivity.this, message, Toast.LENGTH_SHORT).show();
                            if(message.equals("Query successfully")==true) {
                                JSONArray timetable=(JSONArray) response.get("timetable");
                                try{
                                    //final TextView[] tv = new TextView[timetable.length()];
                                    //String time[] = new String[timetable.length()];
                                    for(int i = 0; i<timetable.length(); i++){
                                        JSONObject obj = timetable.getJSONObject(i);
                                        String class_ =(String) obj.get("Class");
                                        String subName = (String) obj.get("Subject");
                                        String time = (String) obj.get("Time");
                                        String date = (String) obj.get("Day_Week");

                                        String classID = "timetable_class";
                                        int resID = getResources().getIdentifier(classID, "id", getPackageName());
                                        TextView tv = findViewById(resID);
                                        tv.setText("Class: "+ class_);

                                        int num = i + 1;
                                        String timeID = "timetable_time" + num;
                                        resID = getResources().getIdentifier(timeID, "id", getPackageName());
                                        tv = findViewById(resID);
                                        tv.setText(time);

                                        if (date.equals("Thứ 2")){
                                            String subID = "timetable_monday_subject" + num;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        if (date.equals("Thứ 3")){
                                            String subID = "timetable_tuesday_subject" + num;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        if (date.equals("Thứ 4")){
                                            String subID = "timetable_wednesday_subject" + num;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        if (date.equals("Thứ 5")){
                                            String subID = "timetable_thursday_subject" + num;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        if (date.equals("Thứ 6")){
                                            String subID = "timetable_fridayday_subject" + num;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        if (date.equals("Thứ 7")){
                                            String subID = "timetable_saturdayday_subject" + num;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        //Toast.makeText(StudentActivity.this, subName, Toast.LENGTH_SHORT).show();
                                    }

                                }catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message=error.toString();
                Toast.makeText(StudentActivity.this, message, Toast.LENGTH_SHORT).show();
                Log.d("c",message);
                //Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);

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
    public void onClickLogout(View view){
        Toast.makeText(this, R.string.logOutSuccess, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(StudentActivity.this, MainActivity.class));
    }
}