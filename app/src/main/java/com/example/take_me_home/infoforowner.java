package com.example.take_me_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.take_me_home.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class infoforowner extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseReference database;
    adapter2 myadapter;
    ArrayList<Iuser> list1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoforowner);
        User use = new User();
        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("Owner").child(ownerphone.pno);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list1=new ArrayList<>();
        myadapter = new adapter2(this,list1);
        recyclerView.setAdapter(myadapter);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Iuser user = dataSnapshot.getValue(Iuser.class);
                    list1.add(user);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}