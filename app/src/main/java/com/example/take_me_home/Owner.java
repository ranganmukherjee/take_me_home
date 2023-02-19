package com.example.take_me_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.take_me_home.Models.User;
import com.example.take_me_home.databinding.ActivityOwnerBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Owner extends AppCompatActivity {
    private FirebaseDatabase owner;
    private DatabaseReference ref;
    Button button3;
    EditText ed1;
    EditText ed2;
    EditText ed3;
//    Button button;
//    ActivityOwnerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityOwnerBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_owner);
//        getSupportActionBar().hide();
        button3 = findViewById(R.id.button3);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Owner.this, "clicked", Toast.LENGTH_SHORT).show();
                owner = FirebaseDatabase.getInstance();
                ref = owner.getReference();
                ownerphone.pno=ed3.getText().toString();
                User user = new User(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString());
                ref.child("users").child(user.getPhone()).setValue(user);
                Intent intent = new Intent(Owner.this,infoforowner.class);
                startActivity(intent);
            }
        });
    }
}