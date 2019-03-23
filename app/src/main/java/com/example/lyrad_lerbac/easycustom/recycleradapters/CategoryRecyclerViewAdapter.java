package com.example.lyrad_lerbac.easycustom.recycleradapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyrad_lerbac.easycustom.Category;
import com.example.lyrad_lerbac.easycustom.R;
import com.example.lyrad_lerbac.easycustom.SousCategoriesFragment;

import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.MyViewHolder> {

    private List<Category> categories;
    private Context context;
    private SousCategoriesFragment nexFragment;

    public CategoryRecyclerViewAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
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
        private FrameLayout frameLayout;
        private Context context;
        Activity a;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.category_item_img);
            name = itemView.findViewById(R.id.category_item_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity1 = (AppCompatActivity)itemView.getContext();
                    SousCategoriesFragment sousCategoriesFragment = new SousCategoriesFragment();
                    activity1.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_content,sousCategoriesFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
        }
    }

}
