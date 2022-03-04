package com.example.a2_2_intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class activity_info extends AppCompatActivity implements View.OnClickListener{

    EditText etName;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        etName = (EditText) findViewById(R.id.etName);
        btn = (Button) findViewById(R.id.btnOK);

        btn.setOnClickListener(this);

        // получаем Intent, который вызывал это Activity
      Intent intent = getIntent();
//// читаем из него action
//        String action = intent.getAction();
//
//        String format = "", textInfo = "";
//
//// в зависимости от action заполняем переменные
//        if (action.equals("com.example.intent.action.showtime")) {
//            format = "HH:mm:ss";
//            textInfo = "Time: ";
//        }
//        else if (action.equals("com.example.intent.action.showdate")) {
//            format = "dd.MM.yyyy";
//            textInfo = "Date: ";
//        }
//        else {
//            format = "dd.MM.yyyy";
//            textInfo = "Date: ";
//        }

// в зависимости от содержимого переменной format
// получаем дату или время в переменную datetime
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        String datetime = sdf.format(new Date(System.currentTimeMillis()));
//
//        TextView tvDate = (TextView) findViewById(R.id.tvInfo);
//        tvDate.setText(textInfo + datetime);

        TextView tvView = (TextView) findViewById(R.id.tvView);

        String lName = intent.getStringExtra("lname");
        tvView.setText("Your name is: " + lName);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", etName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


}