package com.projects.kevinbarassa.thefoorapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

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
        final RecipeItem recipeItem = items.get(position);
        //inflate the created viewholders with actual data from model
        holder.textViewTitle.setText(recipeItem.getTitle());
        holder.textViewDesc.setText(recipeItem.getDesc());
        //Load image with Piccasso
        Picasso.with(context)
                .load(recipeItem.getImageUrl())
                .into(holder.imageView);

        //Add click listener to recipe items
        holder.recipeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rd = new Intent(context, RecipeDetailsActivity.class);
                context.startActivity(rd);
//                Toast.makeText(context, recipeItem.getDesc(), Toast.LENGTH_LONG).show();
            }
        });

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
        public ImageView imageView;
        public RelativeLayout recipeLayout;

        //Constructor is responsible for inflations
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewTitle = (TextView) itemView.findViewById(R.id.text_title);
            textViewDesc = (TextView) itemView.findViewById(R.id.text_story);
            recipeLayout = (RelativeLayout) itemView.findViewById(R.id.recipeLayout);

            //Use a better font
//            Typeface helvetica_font = Typeface.createFromAsset(context.getAssets(),  "fonts/HelveticaNeue.ttf");
//            textViewDesc.setTypeface(helvetica_font);
//            textViewTitle.setTypeface(helvetica_font);



        }
    }
}