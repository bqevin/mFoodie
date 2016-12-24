package com.projects.kevinbarassa.thefoorapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kevin Barassa on 07-Dec-16.
 */


public class BreakfastFrag extends Fragment {
    private LinearLayoutManager lLayout;

    public BreakfastFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_breakfast, container, false);
        List<FoodItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(getActivity());

        RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        FoodListAdapter rcAdapter = new FoodListAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private List<FoodItemObject> getAllItemList(){

        List<FoodItemObject> allItems = new ArrayList<FoodItemObject>();
        allItems.add(new FoodItemObject("Viazi Karai", R.drawable.food_icon));
        allItems.add(new FoodItemObject("Samosa", R.drawable.food_icon));
        allItems.add(new FoodItemObject("Mkate wa Sinia", R.drawable.food_icon));
        allItems.add(new FoodItemObject("Mahamri", R.drawable.food_icon));
        return allItems;
    }
}