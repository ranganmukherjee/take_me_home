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
import android.widget.TextView;
import android.widget.Toast;

import com.example.take_me_home.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class student extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref1";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PROF="prof";
    private static final String KEY_CNO="contact";
    private static final String KEY_DLINK="dlink";

    RecyclerView rv;
    DatabaseReference databse;
    Myadapter myadapter;
    ArrayList<User> list;



//        String req_name = Name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        sharedPreferences =  getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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

//


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.stlogout,menu);
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