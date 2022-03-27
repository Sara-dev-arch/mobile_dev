package com.example.a5_5_broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Обнаружено сообщение: " +
                        intent.getStringExtra("com.example.a5_5_broadcasts.Message"),
                Toast.LENGTH_LONG).show();
    }

}