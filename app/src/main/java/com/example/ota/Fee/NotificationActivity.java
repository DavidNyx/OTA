package com.example.ota.Fee;

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
import com.example.ota.Account;
import com.example.ota.R;
import com.example.ota.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    fee_adapter adapter;
    List<fee> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        auto();
    }
    public void init(){
        recycler_view = findViewById(R.id.recycler_view_notice);
        recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);
        adapter = new fee_adapter(this,data);
        recycler_view.setAdapter(adapter);
    }
    public void auto(){
        JSONObject data = new JSONObject();
        try {
            data.put(Account.account.getHeader(), Account.account.getID());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = Account.account.getURL();
        if (Account.account.getHeader().equals("stuID")){
            url += "class-notification/";
        }
        if (Account.account.getHeader().equals("tcID")){
            url += "notification/";
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("b",response.toString());
                            String message=response.getString("message");
                            Toast.makeText(NotificationActivity.this, message, Toast.LENGTH_SHORT).show();
                            if(message.equals("Query successfully")==true) { // moi sua
                                JSONArray fee=(JSONArray) response.get("notification");
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
                Toast.makeText(NotificationActivity.this, "Error", Toast.LENGTH_SHORT).show();
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
                String topic=(String) obj.get("Topic");
                fee_list.add(new fee(content, topic));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        data=fee_list;
        init();
    }
}

