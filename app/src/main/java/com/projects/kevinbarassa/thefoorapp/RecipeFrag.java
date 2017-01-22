package com.projects.kevinbarassa.thefoorapp;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.projects.kevinbarassa.thefoorapp.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Barassa on 07-Dec-16.
 */


public class RecipeFrag extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ProgressDialog p;
    List<RecipeItem> recipeItems;

    //Swipe to refresh
    SwipeRefreshLayout refresherL;

    private static final String URL_DATA = "http://members.swahilipothub.co.ke/feeds/json.php";


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
        refresherL = (SwipeRefreshLayout) rootView.findViewById(R.id.swiperefresh);

        //Ensures every item on recycler view has fixed size
        recyclerView.setHasFixedSize(true);
        //Layout manager set for current context
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Recycler divider decoration
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));

        //Custom divider
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(), R.drawable.divider));

        return  rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //Create data for the recipe items
        recipeItems = new ArrayList<>();

        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_DATA);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            //Make completely new request
            loadRecipes();
        }

        /*
         *
         * Refreshes Recipes
         */
        //Sets animation color
        refresherL.setColorSchemeColors(Color.parseColor("#ed0202"), Color.parseColor("#c40053"),Color.parseColor("#ffffff"), Color.parseColor("#51af50"));
        refresherL.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // Makes a new network call
                        loadRecipes();

                        //Ensures consistency of data is observed
                        adapter.notifyDataSetChanged();
                        //Clears previous fetched data
                        //recipeItems.clear();

                        //Stop loading animation
                        refresherL.setRefreshing(false);
                    }
                });

    }

    /**
     * Parsing json reponse and passing the data to Recipes adapter
     * */
    private void parseJsonFeed(JSONObject response) {
        //MUST be in the try catch clause
        try {
            // Get Array
            JSONArray recipeArray = response.getJSONArray("feed");
            for (int i = 0; i < recipeArray.length(); i++ ) {
                //fetch individual objects
                JSONObject o = recipeArray.getJSONObject(i);
                //fill the recipe objects
                RecipeItem item = new RecipeItem(
                        o.getString("name"),
                        o.getString("status"),
                        o.getString("image")
                );
                recipeItems.add(item);
            }
            //Create adapter object
            adapter = new RecipeAdapter(recipeItems,getContext());
            //Set adapter
            recyclerView.setAdapter(adapter);

        } catch (JSONException e){
            //Volley Error
            e.printStackTrace();
        }
    }

    private void loadRecipes(){
        p = new ProgressDialog(getActivity());
        p.setMessage("Fetching recipes");
        p.show();
        // making fresh volley request and getting json
        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                URL_DATA, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //VolleyLog.d(TAG, "Response: " + response.toString());
                if (response != null) {
                    parseJsonFeed(response);
                    p.dismiss();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // VolleyLog.d(TAG, "Error: " + error.getMessage());
                //Dismiss dialog
                p.dismiss();
                //Give error
                Toast.makeText(getActivity(),"Please check your internet connection first.",Toast.LENGTH_LONG).show();

            }
        });

        // Adding request to volley request queue
        AppController.getInstance().addToRequestQueue(jsonReq);
    }

}