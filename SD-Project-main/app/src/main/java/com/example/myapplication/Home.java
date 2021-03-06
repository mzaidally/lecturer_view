package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class Home extends AppCompatActivity implements View.OnClickListener{
    //creatings variables
    TextView fullName;
    FirebaseUser fAuth;
    DatabaseReference fdata;
    String userId;
    private Button account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //constants
        fullName = findViewById(R.id.full_Name);
        fAuth = FirebaseAuth.getInstance().getCurrentUser() ;
        //assert fAuth != null;
        if (fAuth != null) {
            userId = fAuth.getUid();
        }
        fdata = FirebaseDatabase.getInstance().getReference();
        account =  findViewById(R.id.btnAccount);
        account.setOnClickListener(this);


        //database object for referencing objects in database for use
        DatabaseReference data_ref = FirebaseDatabase.getInstance().getReference("Users/" + userId);
        data_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String val = snapshot.child("fullName").getValue(String.class);
                fullName.setText(val);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    //when account button pressed takes user to account page
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAccount:
                startActivity(new Intent(this, Account.class));
                break;
        }
    }
}