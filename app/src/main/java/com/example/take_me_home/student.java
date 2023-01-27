package com.example.take_me_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.take_me_home.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class student extends AppCompatActivity {
    RecyclerView rv;
    DatabaseReference databse;
    Myadapter myadapter;
    ArrayList<User> list;



//        String req_name = Name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
//        tv1 =
//        tv2 = findViewById(R.id.Email_2);
//        tv3 = findViewById(R.id.profession_2);
//        tv4 = findViewById(R.id.cno_2);
//        tv5 = findViewById(R.id.dlink_2);


        //recycler view stuff
        rv = findViewById(R.id.rv);
        databse = FirebaseDatabase.getInstance().getReference("users");
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myadapter = new Myadapter(this,list);
        rv.setAdapter(myadapter);
        databse.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        Myadapter ad = new Myadapter();
//        String p=ad.getphone();


    }


}