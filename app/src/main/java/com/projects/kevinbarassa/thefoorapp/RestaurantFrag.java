package com.projects.kevinbarassa.thefoorapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        View rootView = inflater.inflate(R.layout.restaurant_item, container, false);
        TextView plc = (TextView) rootView.findViewById(R.id.placeName);
        // Inflate the layout for this fragment
        return rootView;
    }

}