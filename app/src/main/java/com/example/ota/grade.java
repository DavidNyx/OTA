package com.example.ota;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class grade extends AppCompatActivity {
    RecyclerView recycler_view;
    score_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        recycler_view = findViewById(R.id.recycler_view);
        setRecyclerView();
        //auto();
    }
    private void setRecyclerView(){
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new score_adapter(this, getList());
        recycler_view.setAdapter(this.adapter);
    }
    private List<score> getList(){
        List<score> score_list=new ArrayList<>();
        score_list.add(new score(1,"Toan",2,3,2,3,1,2,3,4));
        return score_list;
    }
    public void auto(){
        JSONObject data = null;
        data = new JSONObject();
        try { // day la data truyen cho server
            data.put("stuID",Account.account.getID());
        } catch (JSONException e) {
            e.printStackTrace();
        }
            final String url = "https://ota-be-server.herokuapp.com/students/grade/";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d("b",response.toString());
                                String message=response.getString("message");
                                Toast.makeText(grade.this, message, Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(grade.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
    }
    public void read_json_grade(JSONArray grade)  {
        try{
            for(int i = 0; i<grade.length(); i++){
                JSONObject obj = grade.getJSONObject(i);
                int SubId=(int) obj.get("SubId");
                String SubName=(String) obj.get("SubName");
                int grade_15_1=(int) obj.get("15phut_1");
                int grade_15_2=(int) obj.get("15phut_2");
                int grade_15_3=(int) obj.get("15phut_3");
                int grade_15_4=(int) obj.get("15phut_4");
                int grade_45_1=(int) obj.get("45phut_1");
                int grade_45_2=(int) obj.get("45phut_2");
                int giuaki=(int) obj.get("giuaki");
                int cuoiki=(int) obj.get("cuoiki");
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
