package com.example.take_me_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = ed1.getText().toString();
                String b = ed2.getText().toString();
                String c = ed3.getText().toString();
                String d = ed4.getText().toString();
                String e = ed5.getText().toString();
                Intent intent = new Intent(S_signup.this,student.class);
                intent.putExtra("Name",a);
                intent.putExtra("Email",b);
                intent.putExtra("profession",c);
                intent.putExtra("cno",d);
                intent.putExtra("dlink",e);
                startActivity(intent);
            }
        });
    }
}