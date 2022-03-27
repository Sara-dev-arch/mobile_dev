package com.example.a5_3_notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickToast(View v){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Текстовое сообщение", Toast.LENGTH_SHORT);
        toast.show();

    }
}