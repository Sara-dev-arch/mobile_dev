package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    final String LOG_TAG = "MyLogs";

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "MyService onCreate");
    }

    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "MyService onBind");
        return new Binder();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(LOG_TAG, "MyService onRebind");
    }

    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "MyService onUnbind");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MyService onDestroy");
    }
}