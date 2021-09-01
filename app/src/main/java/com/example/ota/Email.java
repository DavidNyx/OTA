package com.example.ota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        sendEmail(editEmail.getText().toString(),editSubject.getText().toString(),editMessage.getText().toString());
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