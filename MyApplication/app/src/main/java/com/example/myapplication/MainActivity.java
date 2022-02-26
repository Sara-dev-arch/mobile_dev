package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    ImageButton BtnUp;
    ImageButton BtnDown;
    ImageButton BtnRest;

    private int score = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainTxt);
        BtnUp = (ImageButton) findViewById(R.id.BtnUp);
        BtnDown = (ImageButton) findViewById(R.id.BtnDown);
        BtnRest = (ImageButton) findViewById(R.id.BtnReset);

        BtnUp.setOnClickListener(clickListener);
        BtnDown.setOnClickListener(clickListener);
        BtnRest.setOnClickListener(clickListener);

    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Resources res = getResources();
            String s;
            switch (v.getId()) {
                case R.id.BtnUp:
                    score ++;
                    s = "Кнопка нажата " + res.getQuantityString(R.plurals.plurals, score, score);
                    mainText.setText(s.toCharArray(),0, s.length());
                    break;
                case R.id.BtnDown:
                    if (score == 0){
                        score = 0;
                    } else {
                        score --;
                    }
                    s = "Кнопка нажата " + res.getQuantityString(R.plurals.plurals, score, score);
                    mainText.setText(s.toCharArray(),0, s.length());
                    break;
                case R.id.BtnReset:
                    score = 0;
                    s = "Кнопка нажата " + res.getQuantityString(R.plurals.plurals, score, score);
                    mainText.setText(s.toCharArray(),0, s.length());
                    break;
            }
        }
    };




}

