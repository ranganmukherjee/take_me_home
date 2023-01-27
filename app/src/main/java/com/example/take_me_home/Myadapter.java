package com.example.take_me_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.take_me_home.Models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Context context;
    ArrayList<User> list;

    public Myadapter() {
    }

    public Myadapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }
//

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new MyViewHolder(v);
    }
//    student t = new student();
//    String name  = t.getTv1().toString();
//    String email = t.getTv2().toString();
//    String prof = t.getTv3().toString();
//    String cno = t.getTv4().toString();
//    String dlink = t.getTv5().toString();
    private FirebaseDatabase owner;
    private DatabaseReference ref;
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        User use = new User();
        User user = list.get(position);
        holder.textView9.setText(user.getName());
        holder.textView10.setText(user.getPhone());
        holder.textView13.setText(user.getAddress());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> student=new HashMap<>();

                student.put("Name",Info.name);
                student.put("Email", Info.email);
                student.put("profession", Info.prof);
                student.put("cno", Info.cno);
                student.put("dlink", Info.dlink);

                owner = FirebaseDatabase.getInstance();
                ref = owner.getReference();
                ref.child("Owner").child(user.getPhone()).child(Info.cno).setValue(student);

//                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//                DatabaseReference tasksRef = rootRef.child("USERS").push();
//                tasksRef.setValue(student);
            }
        });
    }


    public String getphone(){
        User u = new User();
        String p = u.getPhone();
        return p;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView9,textView10,textView13;
        Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView9 = itemView.findViewById(R.id.textView9);
            textView10 = itemView.findViewById(R.id.textView10);
            textView13=itemView.findViewById(R.id.textView13);
            button = itemView.findViewById(R.id.interested);

        }
    }
}
