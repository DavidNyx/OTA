package com.example.ota.ViewGrade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.ota.Account;
import com.example.ota.AttendanceMenu;
import com.example.ota.ViewAttendance.ViewAttendance;
import com.example.ota.ViewGrade.GradeModel;
import com.example.ota.ViewGrade.GradeAdapter;
import com.example.ota.R;
import com.example.ota.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewGrade extends AppCompatActivity {

    RecyclerView recycler_view;
    List<GradeModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grade);
    }
    public void init(){
        recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);
        GradeAdapter adapter = new GradeAdapter(this,data);
        recycler_view.setAdapter(adapter);
    }
    public void VG_Query(View view){
        EditText SubjectName=findViewById(R.id.VG_SubjectName);
        EditText Class=findViewById(R.id.VG_Class);
        JSONObject data = null;
        data = new JSONObject();
        try {
            data.put("id",Account.account.getID());
            data.put("class",Class.getText().toString());
            data.put("subjectName",SubjectName.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String url = Account.account.getURL() + "viewgrade/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("b",response.toString());
                            String message=response.getString("message");
                            Toast.makeText(ViewGrade.this, message, Toast.LENGTH_SHORT).show();
                            if(message.equals("Query successfully")==true) { // moi sua
                                JSONArray grade=(JSONArray) response.get("grade");
                                read_json_grade(grade);
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
            }
        });
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
    }
    public void read_json_grade(JSONArray grade)  {
        List<GradeModel> grade_list=new ArrayList<>();
        try{
            for(int i = 0; i<grade.length(); i++){
                JSONObject obj = grade.getJSONObject(i);
                String StudentName=(String) obj.get("StudentName");
                double grade_15_1= Double.valueOf(obj.get("15phut_1").toString());
                double grade_15_2=Double.valueOf(obj.get("15phut_2").toString());
                double grade_15_3=Double.valueOf(obj.get("15phut_3").toString());
                double grade_15_4=Double.valueOf(obj.get("15phut_4").toString());
                double grade_45_1=Double.valueOf(obj.get("45phut_1").toString());
                double grade_45_2=Double.valueOf(obj.get("45phut_2").toString());;
                double giuaki=Double.valueOf(obj.get("giuaki").toString());;
                double cuoiki=Double.valueOf(obj.get("cuoiki").toString());;
                grade_list.add(new GradeModel(StudentName,grade_15_1,grade_15_2,grade_15_3,grade_15_4,grade_45_1,grade_45_2,giuaki,cuoiki));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        data=grade_list;
        init();
    }
}