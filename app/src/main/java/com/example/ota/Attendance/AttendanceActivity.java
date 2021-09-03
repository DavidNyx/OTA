package com.example.ota.Attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ota.Account;
import com.example.ota.R;
import com.example.ota.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    AttendanceAdapter adapter;
    List<Attendance> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        auto();
    }
    public void init(){
        recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);
        adapter = new AttendanceAdapter(this,data);
        recycler_view.setAdapter(adapter);
    }
    public void auto(){
        JSONObject data = new JSONObject();
        try { // day la data truyen cho server
            data.put(Account.account.getHeader(),Account.account.getID());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String url = Account.account.getURL() + "attendance/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("b",response.toString());
                            String message=response.getString("message");
                            Toast.makeText(AttendanceActivity.this, message, Toast.LENGTH_SHORT).show();
                            if(message.equals("Query successfully")) { // moi sua
                                JSONArray Attendance=(JSONArray) response.get("attendance");
                                read_json_attendance(Attendance);
                            }
                        }catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    //}
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AttendanceActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
    }
    public void read_json_attendance(JSONArray attendance)  {
        List<Attendance> attendance_list=new ArrayList<>();
        try{
            for(int i = 0; i<attendance.length(); i++){
                JSONObject obj = attendance.getJSONObject(i);
                int SubId=(int) obj.get("SubId");
                String SubName=(String) obj.get(("SubName"));
                int Week1=(int) obj.get(("Week1"));
                int Week2=(int) obj.get(("Week2"));
                int Week3=(int) obj.get(("Week3"));
                int Week4=(int) obj.get(("Week4"));
                int Week5=(int) obj.get(("Week5"));
                int Week6=(int) obj.get(("Week6"));
                int Week7=(int) obj.get(("Week7"));
                int Week8=(int) obj.get(("Week8"));
                int Week9=(int) obj.get(("Week9"));
                int Week10=(int) obj.get(("Week10"));
                attendance_list.add(new Attendance(SubId,SubName,Week1,Week2,Week3,Week4,Week5,Week6,Week7,Week8,Week9,Week10));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        data=attendance_list;
        init();
    }
}
