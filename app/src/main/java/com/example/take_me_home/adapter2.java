package com.example.take_me_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class adapter2 extends RecyclerView.Adapter<adapter2.Myviewholder>{
    Context ct;

    ArrayList<Iuser> list;

    public adapter2(Context context, ArrayList<Iuser> list) {
        this.ct = context;
        this.list = list;
    }

    @NonNull
    @Override
    public adapter2.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(ct).inflate(R.layout.item2,parent,false);
        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter2.Myviewholder holder, int position) {
        Iuser use = list.get(position);
        holder.setdata(use.getName(),use.getCno(),use.getProfession());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Myviewholder extends RecyclerView.ViewHolder{

        TextView name,phoneno,profession;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.sname);
            phoneno =itemView.findViewById(R.id.spno);
            profession = itemView.findViewById(R.id.sp);
        }

        public void setdata(String nm, String ph, String prof) {
            name.setText(nm);
            phoneno.setText(ph);
            profession.setText(prof);

        }
    }
}
