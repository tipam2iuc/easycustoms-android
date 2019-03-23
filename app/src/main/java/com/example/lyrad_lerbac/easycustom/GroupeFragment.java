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

import com.example.lyrad_lerbac.easycustom.recycleradapters.GroupRecyclerViewAdapter;
import com.example.lyrad_lerbac.easycustom.recycleradapters.SousCategoryRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class GroupeFragment extends Fragment {

    View view;
    List<Groupe> groupes;
    RecyclerView recyclerView;

    public GroupeFragment(){}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_group,container,false);
        recyclerView = view.findViewById(R.id.recycler_groups);
        SousCategoryRecyclerViewAdapter adapter = new SousCategoryRecyclerViewAdapter(new ArrayList<SousCategory>(),getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groupes = new ArrayList<>();
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
        groupes.add(new Groupe("Groupe name",R.drawable.malt));
    }
}
