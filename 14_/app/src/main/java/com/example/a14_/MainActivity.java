package com.example.a14_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    Button ok_btn, cnc_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.main_textview);
        mainButton = findViewById(R.id.main_button);
        mainEditText = findViewById(R.id.main_edittext);
        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);
        mainListView = findViewById(R.id.main_listview);

        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);


        mainTextView.setText("Set in Java!");

        mainButton.setOnClickListener(this);

        mainListView.setOnItemClickListener(this);

        ok_btn.setOnClickListener(oclBtn);
        cnc_btn.setOnClickListener(oclBtn);


    }

    @Override
    public void onClick(View v) {
        if (!(mNameList.contains(mainEditText.getText().toString()))){
            mNameList.add(mainEditText.getText().toString());
            Collections.sort(mNameList);
            mArrayAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(getApplicationContext(), "Элемент уже существует!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ":" + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString() + " is learning Android development!");
        mNameList.remove(position);
        Collections.sort(mNameList);
        mArrayAdapter.notifyDataSetChanged();
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ok_btn:
                    // кнопка ОК
                    Toast.makeText(getApplicationContext(), "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cnc_btn:
                    // кнопка Cancel
                    Toast.makeText(getApplicationContext(), "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                    break;

            }

        }
    };



}