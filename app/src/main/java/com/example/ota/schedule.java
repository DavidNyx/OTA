package com.example.ota;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class schedule extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        auto();
    }

    public void auto() {
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
                            Toast.makeText(schedule.this, message, Toast.LENGTH_SHORT).show();
                            if(message.equals("Query successfully")==true) {
                                JSONArray timetable=(JSONArray) response.get("timetable");
                                try{
                                    for(int i = 0; i<timetable.length(); i++){
                                        JSONObject obj = timetable.getJSONObject(i);
                                        String class_ =(String) obj.get("Class");
                                        String subName = (String) obj.get("Subject");
                                        String time = (String) obj.get("Time");
                                        String date = (String) obj.get("Day_Week");
                                        int stt = (int) obj.get("STT");

                                        String classID = "timetable_class";
                                        int resID = getResources().getIdentifier(classID, "id", getPackageName());
                                        TextView tv = findViewById(resID);
                                        tv.setText("Class: "+ class_);

                                        String timeID = "timetable_time" + stt;
                                        resID = getResources().getIdentifier(timeID, "id", getPackageName());
                                        tv = findViewById(resID);
                                        tv.setText(time);

                                        if (date.equals("Thứ 2")){
                                            String subID = "timetable_monday_subject" + stt;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        else if (date.equals("Thứ 3")){
                                            String subID = "timetable_tuesday_subject" + stt;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        else if (date.equals("Thứ 4")){
                                            String subID = "timetable_wednesday_subject" + stt;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        else if (date.equals("Thứ 5")){
                                            String subID = "timetable_thursday_subject" + stt;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        else if (date.equals("Thứ 6")){
                                            String subID = "timetable_friday_subject" + stt;
                                            resID = getResources().getIdentifier(subID, "id", getPackageName());
                                            tv = findViewById(resID);
                                            tv.setText(subName);
                                        }
                                        else if (date.equals("Thứ 7")){
                                            String subID = "timetable_saturday_subject" + stt;
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
                Toast.makeText(schedule.this, message, Toast.LENGTH_SHORT).show();
                Log.d("c",message);
                //Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);

    }
}
