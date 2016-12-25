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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
    private ProgressDialog p;
    List<RecipeItem> recipeItems;
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
        //Fetch the receipts
        loadRecipes();

    }
    private void loadRecipes() {
        p = new ProgressDialog(getActivity());
        p.setMessage("Checking all new Recipes");
        p.show();

        StringRequest  stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        p.dismiss();
                        //MUST be in the try catch clause
                        try {
                            //Get the Object
                            JSONObject jsonObj = new JSONObject(response);
                            // Get Array
                            JSONArray recipeArray = jsonObj.getJSONArray("feed");
                            for (int i = 0; i < recipeArray.length(); i++ ) {
                                //fetch individual objects
                                JSONObject o = recipeArray.getJSONObject(i);
                                //fill the recipe objects
                                RecipeItem item = new RecipeItem(
                                        o.getString("name"),
                                        o.getString("status")
                                );
                                recipeItems.add(item);
                            }
                            //Create adapter object
                            adapter = new RecipeAdapter(recipeItems,getContext());
                            //Set adapter
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Volley Error
                        Toast.makeText(getContext(), "Error: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                        //Dismiss dialogue and print error
                        p.dismiss();
                    }
                });
        RequestQueue requestQue = Volley.newRequestQueue(getContext());
        requestQue.add(stringRequest);
    }
}