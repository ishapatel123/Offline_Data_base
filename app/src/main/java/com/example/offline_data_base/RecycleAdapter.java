package com.example.offline_data_base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>
{
    MainActivity mainActivity;
    ArrayList<Modelclass> list;

    public RecycleAdapter(MainActivity mainActivity, ArrayList<Modelclass> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recycle_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.number.setText(list.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.recyclename);
            number=itemView.findViewById(R.id.recyclenumber);
        }
    }
}
