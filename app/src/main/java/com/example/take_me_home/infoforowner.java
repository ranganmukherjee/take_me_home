package com.example.take_me_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.take_me_home.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class infoforowner extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_ADRS="adrs";
    private static final String KEY_PNO="pno";
    RecyclerView recyclerView;
    DatabaseReference database;
    adapter2 myadapter;
    ArrayList<Iuser> list1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoforowner);
        sharedPreferences =  getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        User use = new User();
        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("Owner").child(sharedPreferences.getString(KEY_PNO,ownerphone.pno));
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logoutmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item .getItemId()){
            case R.id.item1:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}