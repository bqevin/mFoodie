package com.projects.kevinbarassa.thefoorapp;

import android.graphics.Bitmap;

/**
 * Created by Kevin Barassa on 24-Dec-16.
 */


public class RecipeItem {

    private String title;
    private String desc;
    private String imageUrl;

    public RecipeItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}



