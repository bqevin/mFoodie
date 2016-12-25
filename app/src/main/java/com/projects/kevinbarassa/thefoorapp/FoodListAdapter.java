package com.projects.kevinbarassa.thefoorapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kevin Barassa on 24-Dec-16.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodViewHolders> {

    private List<FoodItemObject> itemList;
    private Context context;

    public FoodListAdapter(Context context, List<FoodItemObject> itemList) {
        this.itemList = itemList;
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
        holder.foodName.setText(itemList.get(position).getName());
        holder.foodPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}