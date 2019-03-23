package com.example.lyrad_lerbac.easycustom.recycleradapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrad_lerbac.easycustom.GroupeFragment;
import com.example.lyrad_lerbac.easycustom.R;
import com.example.lyrad_lerbac.easycustom.SousCategory;

import java.util.List;

public class SousCategoryRecyclerViewAdapter extends RecyclerView.Adapter<SousCategoryRecyclerViewAdapter.MyViewHolder> {

    List<SousCategory> categories;
    Context context;

    public SousCategoryRecyclerViewAdapter(List<SousCategory> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(context).inflate(R.layout.sous_category_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.image.setImageResource(categories.get(position).getImage());
        holder.name.setText(categories.get(position).getNom());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.sous_category_item_img);
            name = itemView.findViewById(R.id.sous_category_item_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
                    GroupeFragment groupeFragment = new GroupeFragment();
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_content,groupeFragment)
                            .commit();
                }
            });
        }
    }

}
