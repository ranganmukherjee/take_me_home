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

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Context context;
    ArrayList<User> list;

    public Myadapter() {
    }

    public Myadapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.textView9.setText(user.getName());
        holder.textView10.setText(user.getPhone());
        holder.textView13.setText(user.getAddress());
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "aay", Toast.LENGTH_SHORT).show();
//            }
//        });
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
//            button = itemView.findViewById(R.id.Interested);

        }
    }
}
