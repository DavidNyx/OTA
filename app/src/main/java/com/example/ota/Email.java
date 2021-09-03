package com.example.ota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ota.Grade.grade;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Email extends AppCompatActivity {
    private static final int NOTIFICATION_ID=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

    }

    public void onClickSendEmail(View view){
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editSubject = findViewById(R.id.editSubject);
        EditText editMessage = findViewById(R.id.editMessage);
        JSONObject data = new JSONObject();
        System.out.println(editEmail.getText().toString());
        if(editEmail.getText().toString().isEmpty())
            Toast.makeText(Email.this, "Email is empty. Please enter email to continue.", Toast.LENGTH_SHORT).show();
        else if(editSubject.getText().toString().isEmpty())
            Toast.makeText(Email.this, "Topic is empty. Please enter topic to continue.", Toast.LENGTH_SHORT).show();
        else if(editMessage.getText().toString().isEmpty())
            Toast.makeText(Email.this, "Message is empty. Please enter message to continue.", Toast.LENGTH_SHORT).show();
        else {
            try { // day la data truyen cho server
                data.put(Account.account.getHeader(), Account.account.getID());
                data.put("teacherID", editEmail.getText().toString());
                data.put("topic", editSubject.getText().toString());
                data.put("content", editMessage.getText().toString());
                Log.d("d", data.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final String url = Account.account.getURL() + "absent-letter/";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d("b", response.toString());
                                String message = response.getString("message");
                                Toast.makeText(Email.this, message, Toast.LENGTH_SHORT).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        //}
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Email.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
            VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
        }
    }
    private void sendEmail(String Email,String Subject,String Message){
        Notification notification=new NotificationCompat.Builder(this,Channel.CHANNEL_ID)
                .setContentTitle(Subject)
                .setContentText(Message)
                .setSmallIcon(R.mipmap.ota_icon)
                .build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(notificationManager!=null) {
            notificationManager.notify(getNotificationId(), notification);
        }
    }
    private int getNotificationId(){
        return (int) new Date().getTime();
    }

}