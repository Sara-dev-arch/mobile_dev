package com.example.guessnumber;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.*;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    Integer g_num;
    Integer user_num;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        bControl = (Button)findViewById(R.id.button1);

        g_num = new Random().ints(1, 1, 101).findFirst().getAsInt();
        System.out.println(g_num);

    }

    public void onClick(View v){
        try {
            user_num = Integer.parseInt(etInput.getText().toString());
            if (user_num == g_num){
                tvInfo.setText(getResources().getString(R.string.hit));
            }
            else if (user_num > 100 || user_num < 1){
                tvInfo.setText(getResources().getString(R.string.out_of_range));
            }
            else if (user_num > g_num){
                tvInfo.setText(getResources().getString(R.string.ahead));
            }
            else if (user_num < g_num){
                tvInfo.setText(getResources().getString(R.string.behind));
            }

        } catch (NumberFormatException e) {
            tvInfo.setText(getResources().getString(R.string.error));
        }


    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void reset(View v){
        if (tvInfo.getText() == getResources().getString(R.string.hit)) {
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            g_num = new Random().ints(1, 1, 101).findFirst().getAsInt();
            System.out.println(g_num);
        }
        else {
            tvInfo.setText(getResources().getString(R.string.didnt_guess_first));
        }
    }
}