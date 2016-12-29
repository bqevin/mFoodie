package com.projects.kevinbarassa.thefoorapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Kevin Barassa on 29-Dec-16.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolders> {

    private List<RestaurantItem> items;
    private Context context;

    public RestaurantAdapter(Context context, List<RestaurantItem> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RestaurantAdapter.RestaurantViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, null);
        RestaurantAdapter.RestaurantViewHolders rcv = new RestaurantAdapter.RestaurantViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.RestaurantViewHolders holder, int position) {
        //Initiate the restaurant items
        final RestaurantItem restaurants = items.get(position);

        holder.restaurantName.setText(restaurants.getRestaurantName());
        holder.restaurantPhoto.setImageResource(restaurants.getRestaurantPhoto());
        //Add click listener to Restaurants
        holder.restaurantLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Welcome to "+ restaurants.getRestaurantName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class RestaurantViewHolders extends RecyclerView.ViewHolder{

        public TextView restaurantName;
        public ImageView restaurantPhoto;
        public RelativeLayout restaurantLayout;

        public RestaurantViewHolders(View itemView) {
            super(itemView);

            restaurantName = (TextView)itemView.findViewById(R.id.restName);
            restaurantPhoto = (ImageView)itemView.findViewById(R.id.restImage);
            restaurantLayout = (RelativeLayout) itemView.findViewById(R.id.restLayout);

        }

    }
}