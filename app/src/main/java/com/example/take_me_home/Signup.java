package com.example.take_me_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.take_me_home.Models.user2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
//    private FirebaseDatabase owner1;
//    private DatabaseReference ref1;
    private FirebaseAuth auth;
    FirebaseDatabase db;
    TextView textView;
    Button button;
    EditText ed1;
    EditText ed2;
    EditText ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        textView = findViewById(R.id.tv5);
        button = findViewById(R.id.Save_1);
        ed1= findViewById(R.id.Name_1);
        ed2= findViewById(R.id.Email_1);
        ed3 = findViewById(R.id.profession_1);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = ed1.getText().toString();
                String Email = ed2.getText().toString();
                String password = ed3.getText().toString();
                if(Name.isEmpty()||Email.isEmpty()||password.isEmpty()){
                    Toast.makeText(Signup.this, "Fillup all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    auth.createUserWithEmailAndPassword(ed2.getText().toString(),ed3.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                user2 use = new user2(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString());
                                String id = task.getResult().getUser().getUid();
                                db.getReference().child("ruser").child(id).setValue(use);
                                Intent intent = new Intent(Signup.this,Login.class);
                                startActivity(intent);
                                Toast.makeText(Signup.this, "User created", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });


    }
}