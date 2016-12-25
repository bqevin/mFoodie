package com.projects.kevinbarassa.thefoorapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Barassa on 07-Dec-16.
 */


public class RecipeFrag extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<RecipeItem> recipeItems;


    public RecipeFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_recipe, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        //Ensures every item on recycler view has fixed size
        recyclerView.setHasFixedSize(true);
        //Layout manager set for current context
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return  rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Create data for the recipe items
        recipeItems = new ArrayList<>();

        for (int i = 0; i <= 10; i++){
            RecipeItem recipe = new RecipeItem(
             "Recipe " + i+1, "Lot of description to the recipe title"
            );
            recipeItems.add(recipe);
        }

        adapter = new RecipeAdapter(recipeItems,getContext());
        //Set adapter object
        recyclerView.setAdapter(adapter);

    }
}