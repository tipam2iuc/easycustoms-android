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

import com.example.lyrad_lerbac.easycustom.recycleradapters.SousCategoryRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SousCategoriesFragment extends Fragment {


    View view;
    List<SousCategory> categories;
    RecyclerView recyclerView;


    public SousCategoriesFragment(){}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categories = new ArrayList<>();
        categories.add(new SousCategory("Animaux vivants",R.drawable.animal));
        categories.add(new SousCategory("Viande et abats comestibles",R.drawable.viande));
        categories.add(new SousCategory("Poissons et crustaces. mollusque et autre invertebre aquatique",R.drawable.poissons));
        categories.add(new SousCategory("Lait et produits de la laiterie",R.drawable.lait));
        categories.add(new SousCategory("autres produits d'origine animale",R.drawable.produits));
        categories.add(new SousCategory("Plante vivantes et produit de la floriculture",R.drawable.plante));
        categories.add(new SousCategory("Legumes, plantes, racines, et tubercules alimentaire",R.drawable.legumes));
        categories.add(new SousCategory("Fruits comestible: ecorces d'argumes ou de melons",R.drawable.fruits));
        categories.add(new SousCategory("Cafe, the, mate et epices",R.drawable.cafe));
        categories.add(new SousCategory("Cereales",R.drawable.cereales));
        categories.add(new SousCategory("Produits de minoterie; malt; amidons et fecules; gluten de froment",R.drawable.malt));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sous_categories,container,false);
        recyclerView = view.findViewById(R.id.recycler_sous_categories);
        SousCategoryRecyclerViewAdapter adapter = new SousCategoryRecyclerViewAdapter(categories,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
