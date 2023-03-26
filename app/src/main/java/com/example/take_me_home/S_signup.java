package com.example.take_me_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class S_signup extends AppCompatActivity {
    public EditText ed1;
    public EditText ed2;
    public EditText ed3;
    public EditText ed4;
    public EditText ed5;
    public Button bt;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref1";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PROF="prof";
    private static final String KEY_CNO="contact";
    private static final String KEY_DLINK="dlink";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssignup);
        ed1 = findViewById(R.id.Name_1);
        ed2 = findViewById(R.id.Email_1);
        ed3 = findViewById(R.id.profession_1);
        ed4 = findViewById(R.id.cno_1);
        ed5 = findViewById(R.id.dlink);
        bt = findViewById(R.id.Save_1);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        if (sharedPreferences.contains(KEY_NAME) && sharedPreferences.contains(KEY_EMAIL)
                && sharedPreferences.contains(KEY_PROF) && sharedPreferences.contains(KEY_CNO)
                && sharedPreferences.contains(KEY_DLINK)) {
            Info.name=sharedPreferences.getString(KEY_NAME,"");
            Info.email=sharedPreferences.getString(KEY_EMAIL,"");
            Info.prof=sharedPreferences.getString(KEY_PROF,"");
            Info.cno=sharedPreferences.getString(KEY_CNO,"");
            Info.dlink=sharedPreferences.getString(KEY_DLINK,"");



            Intent intent = new Intent(S_signup.this, student.class);
            startActivity(intent);

            finish();
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = ed1.getText().toString();
                String b = ed2.getText().toString();
                String c = ed3.getText().toString();
                String d = ed4.getText().toString();
                String e = ed5.getText().toString();
                Intent intent = new Intent(S_signup.this,student.class);
                Info.name = a;
                Info.email = b;
                Info.prof = c;
                Info.cno = d;
                Info.dlink = e;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,ed1.getText().toString());
                editor.putString(KEY_EMAIL,ed2.getText().toString());
                editor.putString(KEY_PROF,ed3.getText().toString());
                editor.putString(KEY_CNO,ed4.getText().toString());
                editor.putString(KEY_DLINK,ed5.getText().toString());
                editor.commit();
                startActivity(intent);
            }
        });
    }
}