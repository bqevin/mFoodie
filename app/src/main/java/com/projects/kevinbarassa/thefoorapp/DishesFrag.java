package com.projects.kevinbarassa.thefoorapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Barassa on 07-Dec-16.
 */


public class DishesFrag extends Fragment {

    public DishesFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dishes, container, false);
        List<DishesItem> rowListItem = getAllItemList();


        RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DishesAdapter rcAdapter = new DishesAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private List<DishesItem> getAllItemList(){

        List<DishesItem> allItems = new ArrayList<DishesItem>();
        allItems.add(new DishesItem("Swahili Breakfast", R.drawable.breakfast));
        allItems.add(new DishesItem("Continental Breakfast", R.drawable.breakfast3));
        allItems.add(new DishesItem("Best Biryani", R.drawable.breakfast4));
        allItems.add(new DishesItem("Mshikaki", R.drawable.breakfast5));
        allItems.add(new DishesItem("Indian Cuisine", R.drawable.breakfast6));
        allItems.add(new DishesItem("African Dishes", R.drawable.breakfast7));
        allItems.add(new DishesItem("Best Chicken Tikka", R.drawable.kaimati));
        allItems.add(new DishesItem("Best Burgers", R.drawable.ss));
        allItems.add(new DishesItem("Viazi Karai", R.drawable.ss1));
        allItems.add(new DishesItem("Samosa", R.drawable.ss2));
        allItems.add(new DishesItem("Mkate wa Sinia", R.drawable.ss3));
        allItems.add(new DishesItem("Mahamri", R.drawable.ss4));
        allItems.add(new DishesItem("Viazi Karai", R.drawable.ss5));
        allItems.add(new DishesItem("Samosa", R.drawable.ss6));
        allItems.add(new DishesItem("Kaimati", R.drawable.ss7));
        return allItems;
    }
}