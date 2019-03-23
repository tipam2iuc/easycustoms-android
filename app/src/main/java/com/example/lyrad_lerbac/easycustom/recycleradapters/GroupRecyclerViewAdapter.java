package com.example.lyrad_lerbac.easycustom.recycleradapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrad_lerbac.easycustom.Groupe;
import com.example.lyrad_lerbac.easycustom.R;

import java.util.List;

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.MyViewHolder> {


    List<Groupe> groupes;
    Context context;

    public GroupRecyclerViewAdapter(List<Groupe> groupes, Context context) {
        this.groupes = groupes;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(context).inflate(R.layout.fragment_group,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.image.setImageResource(groupes.get(position).getImage());
        holder.name.setText(groupes.get(position).getNom());

    }

    @Override
    public int getItemCount() {
        return groupes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.group_item_img);
            name = itemView.findViewById(R.id.group_item_name);
        }
    }
}
