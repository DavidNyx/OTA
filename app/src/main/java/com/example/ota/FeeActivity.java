package com.example.ota;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FeeActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    fee_adapter adapter;
    List<fee> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee);
        auto();
    }
    public void init(){
        recycler_view = findViewById(R.id.recycler_view_fee);
        recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);
        adapter = new fee_adapter(this,data);
        recycler_view.setAdapter(adapter);
    }
    public void auto(){
        JSONObject data = null;
        data = new JSONObject();
        try { // day la data truyen cho server
            data.put("stuID",Account.account.getID());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String url = "https://ota-be-server.herokuapp.com/students/tuition-fee/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("b",response.toString());
                            String message=response.getString("message");
                            Toast.makeText(FeeActivity.this, message, Toast.LENGTH_SHORT).show();
                            if(message.equals("Query successfully")==true) { // moi sua
                                JSONArray fee=(JSONArray) response.get("fee");
                                read_json_fee(fee);
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
                Toast.makeText(FeeActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
    }
    public void read_json_fee(JSONArray fee)  {
        List<fee> fee_list=new ArrayList<>();
        try{
            for(int i = 0; i<fee.length(); i++){
                JSONObject obj = fee.getJSONObject(i);
                String content=(String) obj.get("Content");
                fee_list.add(new fee(content));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        data=fee_list;
        init();
    }
}

