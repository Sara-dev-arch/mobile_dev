package com.example.a5_2_notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private NotificationManager notificationManager;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyLogs", "onStartCommand");
        Intent notificationIntent = new Intent(this, MainActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Intent notificationIntent2 = new Intent(this, MainActivity3.class);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(this,
                0, notificationIntent2,
                PendingIntent.FLAG_CANCEL_CURRENT);

        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), "CHANNEL_ID")
                                .setAutoCancel(false)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setWhen(System.currentTimeMillis())
                                .setContentTitle("Title")
                                .setContentText("text")
                .addAction(R.mipmap.ic_launcher, "Открыть 1", pendingIntent)
                        .addAction(R.mipmap.ic_launcher, "Открыть 2", pendingIntent2);

                createChannelIfNeeded(notificationManager);
                notificationManager.notify(1, notificationBuilder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    public static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_ID", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}