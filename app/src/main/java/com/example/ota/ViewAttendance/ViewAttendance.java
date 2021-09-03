package com.example.ota.ViewAttendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ota.Account;
import com.example.ota.ViewGrade.GradeModel;
import com.example.ota.ViewGrade.GradeAdapter;
import com.example.ota.R;
import com.example.ota.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewAttendance extends AppCompatActivity {

    RecyclerView recycler_view;
    AttendanceAdapter adapter;
    List<AttendanceModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);
    }
    public void init(){
        recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);
        adapter = new AttendanceAdapter(this,data);
        recycler_view.setAdapter(adapter);
    }
    public void VA_Query(View view){
        EditText SubjectName=findViewById(R.id.VA_SubjectName);
        EditText Class=findViewById(R.id.VA_Class);
        JSONObject data = null;
        data = new JSONObject();
        try {
            data.put("id",Account.account.getID());
            data.put("class",Class.getText().toString());
            data.put("subjectName",SubjectName.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String url = Account.account.getURL() + "viewattendance/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("b",response.toString());
                            String message=response.getString("message");
                            Toast.makeText(ViewAttendance.this, message, Toast.LENGTH_SHORT).show();
                            if(message.equals("Query successfully")) { // moi sua
                                JSONArray attendance=(JSONArray) response.get("attendance");
                                read_json_attendance(attendance);
                            }
                        }catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    //}
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewAttendance.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
    }
    public void read_json_attendance(JSONArray attendance)  {
        List<AttendanceModel> attendance_list=new ArrayList<>();
        try{
            for(int i = 0; i<attendance.length(); i++){
                JSONObject obj = attendance.getJSONObject(i);
                String StudentID=(String) obj.get("StuId");
                String StudentName=(String) obj.get("StuName");
                int week_1= Integer.valueOf(obj.get("Week1").toString());
                int week_2= Integer.valueOf(obj.get("Week2").toString());
                int week_3= Integer.valueOf(obj.get("Week3").toString());
                int week_4= Integer.valueOf(obj.get("Week4").toString());
                int week_5= Integer.valueOf(obj.get("Week5").toString());
                int week_6= Integer.valueOf(obj.get("Week6").toString());
                int week_7= Integer.valueOf(obj.get("Week7").toString());
                int week_8= Integer.valueOf(obj.get("Week8").toString());
                int week_9= Integer.valueOf(obj.get("Week9").toString());
                int week_10= Integer.valueOf(obj.get("Week10").toString());


                attendance_list.add(new AttendanceModel(StudentID, StudentName,week_1,week_2,week_3,week_4,week_5,week_6,week_7,week_8,week_9,week_10));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        data=attendance_list;
        init();
    }
}