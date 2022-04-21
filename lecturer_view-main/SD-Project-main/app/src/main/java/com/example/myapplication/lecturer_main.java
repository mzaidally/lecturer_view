package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class lecturer_main extends AppCompatActivity {

    private Button btnAddToDatabase;
    private EditText course_name;
    private static final String TAG = "AddToDatabase";
    private String userID;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_main);
        course_name=(EditText) findViewById(R.id.course_name);
        btnAddToDatabase=(Button) findViewById(R.id.add_course_name);

       // myRef=FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        myRef=FirebaseDatabase.getInstance().getReference()
        .child("courses");
        btnAddToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertCourseData();

            }
        });

    }

    private void insertCourseData(){
        String name = course_name.getText().toString();
        LecturerData lecturerData = new LecturerData(name);

        myRef.push().setValue(lecturerData);

        Toast.makeText(lecturer_main.this,"Data inserted",Toast.LENGTH_SHORT).show();

    }
}