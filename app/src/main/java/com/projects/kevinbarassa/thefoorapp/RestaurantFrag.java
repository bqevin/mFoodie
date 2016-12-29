package com.projects.kevinbarassa.thefoorapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Barassa on 07-Dec-16.
 */


public class RestaurantFrag extends Fragment {

    public RestaurantFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant, container, false);
        List<RestaurantItem> rowListItem = getAllItemList();


        RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RestaurantAdapter rcAdapter = new RestaurantAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    private List<RestaurantItem> getAllItemList(){

        List<RestaurantItem> allItems = new ArrayList<RestaurantItem>();
        allItems.add(new RestaurantItem("Barka Restaurant", R.drawable.ss3));
        allItems.add(new RestaurantItem("Signature Cafe", R.drawable.ss4));
        allItems.add(new RestaurantItem("Aisha Restaurant", R.drawable.ss5));
        allItems.add(new RestaurantItem("Blue Room Hotel", R.drawable.ss6));
        allItems.add(new RestaurantItem("Sairock Hotel", R.drawable.ss7));
        return allItems;
    }

}