package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Account extends AppCompatActivity implements View.OnClickListener {
    
    // Logout button

    private Button logout;
    //refernce objects for student,lecturer textviews
    private TextView student_page,lecturer_page;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        logout =  findViewById(R.id.btnLogout);
        logout.setOnClickListener(this);

        //making a listener to deal with click of the student textview
        student_page= findViewById(R.id.student);
        student_page.setOnClickListener(this);
        //making a listener to deal with click of the lecturer textview
        lecturer_page= findViewById(R.id.lecturer);
        lecturer_page.setOnClickListener(this);


    }
    
    // Takes user back to login page

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnLogout:
                startActivity(new Intent(this, Login.class));
                break;


            case R.id.student:
                startActivity(new Intent(this,Student_View.class));
                break;

            case R.id.lecturer:
                startActivity(new Intent(this,Lecturer_View.class));
                break;
        }
    }
}
