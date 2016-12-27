package com.projects.kevinbarassa.thefoorapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Kevin Barassa on 24-Dec-16.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private  List<RecipeItem> items;
    private Context context;

    //Constructor
    public RecipeAdapter(List<RecipeItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the items
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);
        //return a copy of the created viewholder
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Initiate the recipe items
        RecipeItem recipeItem = items.get(position);
        //inflate the created viewholders with actual data from model
        holder.textViewTitle.setText(recipeItem.getTitle());
        holder.textViewDesc.setText(recipeItem.getDesc());

    }

    @Override
    public int getItemCount() {
        //Get the size of the data array
        return items.size();
    }

    //This class deals with every single item display in the layout
    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTitle;
        public TextView textViewDesc;

        //Constructor is responsible for inflations
        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            //Use a better font
//            Typeface helvetica_font = Typeface.createFromAsset(context.getAssets(),  "fonts/HelveticaNeue.ttf");
//            textViewDesc.setTypeface(helvetica_font);
//            textViewTitle.setTypeface(helvetica_font);

        }
    }
}