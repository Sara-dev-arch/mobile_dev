package com.example.a5_5_broadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static final String WHERE_MY_CAT_ACTION = "com.example.a5_5_broadcasts.action.CAT";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";

    public void sendMessage(View view) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(this, MyReceiver.class);


        intent.setAction(WHERE_MY_CAT_ACTION);
        intent.putExtra("com.example.a5_5_broadcasts.Message", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setComponent(componentName);
        sendBroadcast(intent);
    }

}