package com.example.ota.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.ota.Chanel;
import com.example.ota.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Date;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
        RemoteMessage.Notification notification=remoteMessage.getNotification();
        if(notification==null){
            return;
        }
        String strTitle = notification.getTitle();
        String strMessage = notification.getBody();

        sendNotification(strTitle,strMessage);
    }
    private void sendNotification(String strTitle,String strMessage){
        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(this, Chanel.CHANNEL_ID)
                .setContentTitle(strTitle)
                .setContentText(strMessage)
                .setSmallIcon(R.mipmap.ota_icon);
        Notification notification=notificationBuilder.build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager!=null){
            notificationManager.notify(getNotificationId(),notification);
        }
    }
    private int getNotificationId(){
        return (int) new Date().getTime();
    }
}
