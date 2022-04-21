package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lecturer_View extends AppCompatActivity implements View.OnClickListener {

    private Button get_started;// this button allows you to start the process of becoming a lecturer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_view);
        //button for get started
        get_started = findViewById(R.id.get_started);
        get_started.setOnClickListener(this);
    }

    //listener for get started button
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.get_started:
                startActivity(new Intent(this, lecturer_main.class));//takes you to course creation page once get started button is clicked
                break;
        }
    }
}