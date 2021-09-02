package com.example.ota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class EditGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_grade);
    }
    public void EG_Submit(View view){
        EditText EG_ID = findViewById(R.id.EG_ID);
        EditText EG_Subject = findViewById(R.id.EG_Subject);
        EditText EG_Test1 = findViewById(R.id.EG_Test1);
        EditText EG_Test2 = findViewById(R.id.EG_Test2);
        EditText EG_Test3 = findViewById(R.id.EG_Test3);
        EditText EG_Test4 = findViewById(R.id.EG_Test4);
        EditText EG_Test5 = findViewById(R.id.EG_Test5);
        EditText EG_Test6 = findViewById(R.id.EG_Test6);
        EditText EG_Test7 = findViewById(R.id.EG_Test7);
        EditText EG_Test8 = findViewById(R.id.EG_Test8);

        JSONObject data=new JSONObject();
        try { // day la data truyen cho server
            data.put("TeacherID",Account.account.getID());
            data.put("subjectName",EG_Subject.getText().toString());
            data.put("StudentID",EG_ID.getText().toString());
            data.put("test1",check(EG_Test1));
            data.put("test2",check(EG_Test2));
            data.put("test3",check(EG_Test3));
            data.put("test4",check(EG_Test4));
            data.put("test5",check(EG_Test5));
            data.put("test6",check(EG_Test6));
            data.put("test7",check(EG_Test7));
            data.put("test8",check(EG_Test8));
            Log.d("h",data.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String url = "https://ota-be-server.herokuapp.com/teachers/editgrade/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("b",response.toString());
                            String message=response.getString("message");
                            Toast.makeText(EditGrade.this, message, Toast.LENGTH_SHORT).show();
                        }catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message=error.toString();
                Log.d("c",message);
                Toast.makeText(EditGrade.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
    }
    public int check(EditText text){
        int temp= Integer.parseInt(text.getText().toString());
        if(temp>=0&&temp<=10)
            return temp;
        else
            return -1;
    }
}