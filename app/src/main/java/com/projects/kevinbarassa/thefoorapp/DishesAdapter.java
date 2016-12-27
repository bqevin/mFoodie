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
 * Created by Kevin Barassa on 24-Dec-16.
 */

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.FoodViewHolders> {

    private List<DishesItem> items;
    private Context context;

    public DishesAdapter(Context context, List<DishesItem> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public FoodViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dish_item, null);
        FoodViewHolders rcv = new FoodViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(FoodViewHolders holder, int position) {
        //Initiate the dishes items
        final DishesItem dishesItem = items.get(position);

        holder.foodName.setText(dishesItem.getName());
        holder.foodPhoto.setImageResource(dishesItem.getPhoto());
        //Add click listener to Dishes items
        holder.dishesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked: "+ dishesItem.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class FoodViewHolders extends RecyclerView.ViewHolder{

        public TextView foodName;
        public ImageView foodPhoto;
        public RelativeLayout dishesLayout;

        public FoodViewHolders(View itemView) {
            super(itemView);

            foodName = (TextView)itemView.findViewById(R.id.food_name);
            foodPhoto = (ImageView)itemView.findViewById(R.id.food_photo);
            dishesLayout = (RelativeLayout) itemView.findViewById(R.id.dishesLayout);

        }

    }
}