package com.example.lyrad_lerbac.easycustom;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyrad_lerbac.easycustom.recycleradapters.CategoryRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {


    View view;
    List<Category> categories;
    RecyclerView recyclerView;
    SousCategoriesFragment sousCategory = new SousCategoriesFragment();


    public CategoriesFragment(){}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categories = new ArrayList<>();
        categories.add(new Category("Animaux vivants",R.drawable.animal));
        categories.add(new Category("Viande et abats comestibles",R.drawable.viande));
        categories.add(new Category("Poissons et crustaces. mollusque et autre invertebre aquatique",R.drawable.poissons));
        categories.add(new Category("Lait et produits de la laiterie",R.drawable.lait));
        categories.add(new Category("autres produits d'origine animale",R.drawable.produits));
        categories.add(new Category("Plante vivantes et produit de la floriculture",R.drawable.plante));
        categories.add(new Category("Legumes, plantes, racines, et tubercules alimentaire",R.drawable.legumes));
        categories.add(new Category("Fruits comestible: ecorces d'argumes ou de melons",R.drawable.fruits));
        categories.add(new Category("Cafe, the, mate et epices",R.drawable.cafe));
        categories.add(new Category("Cereales",R.drawable.cereales));
        categories.add(new Category("Produits de minoterie; malt; amidons et fecules; gluten de froment",R.drawable.malt));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_categories,container,false);
        recyclerView = view.findViewById(R.id.recycler_categories);
        CategoryRecyclerViewAdapter categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(categories,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(categoryRecyclerViewAdapter);;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
